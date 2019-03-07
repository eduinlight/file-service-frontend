(ns file-service-frontend.states.globals
  (:require
   [file-service-frontend.api :as api]
   [file-service-frontend.utils :as utils]
   [reagent.core :as reagent :refer [atom]]))

(def paths (atom []))
(def files (atom []))
(def file-selected (atom nil))
(def loading (atom false))

;inicializar watchers
;watcher en la barra de direccion para que cada vez que cambie se consulte servidor por listado de archivos de ultima carpeta
(add-watch paths :paths-watcher (fn [_ paths old new]
  (reset! file-selected nil)
  (reset! files [])
  (reset! loading true)
  (let [{:keys [path]} (last new)]
    (api/list-files path (fn [f_list]
      (reset! files (utils/sorted-files f_list))
      (reset! loading false))))))
