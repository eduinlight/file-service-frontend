(ns file-service-frontend.states.globals
  (:require
   [file-service-frontend.api :as api]
   [file-service-frontend.utils :as utils]
   [reagent.core :as reagent :refer [atom]]))

(def paths (atom []))
(def files (atom []))
(def file-selected (atom nil))
(def loading (atom false))
(def modal-add-file-open (atom false))
(def modal-add-folder-open (atom false))
(def modal-change-name-open (atom false))
(def modal-file-view (atom false))

(defn update-path [path]
  (reset! file-selected nil)
  (reset! files [])
  (reset! loading true)
  (api/list-files path (fn [f_list]
    (reset! files f_list)
    (reset! loading false))))

;inicializar watchers
;watcher en la barra de direccion para que cada vez que cambie se consulte servidor por listado de archivos de ultima carpeta
(add-watch paths :paths-watcher (fn [_ paths old new]
  (update-path (:path (last new)))))


;watcher en la barra de direccion para que cada vez que cambie se consulte servidor por listado de archivos de ultima carpeta
(add-watch files :files-watcher (fn [_ files old new]
  (if (not (= old new))
    (swap! files utils/sorted-files))))