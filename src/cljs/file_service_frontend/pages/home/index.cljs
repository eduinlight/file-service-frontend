<<<<<<< HEAD
(ns file-service-frontend.pages.home
  (:require
   [reagent.core :as r :refer [atom]]
   [file-service-frontend.states.globals :as sglobals]
   [file-service-frontend.actions.globals :as aglobals]
   [file-service-frontend.api :as api]
   [file-service-frontend.components.loading :refer [loading]]
   [file-service-frontend.pages.home.toolbar :refer [toolbar]]
   [file-service-frontend.pages.home.modal-add-file :refer [modal-add-file]]
   [file-service-frontend.pages.home.modal-file-view :refer [modal-file-view]]
   [file-service-frontend.pages.home.pathbar :refer [pathbar]]
   [file-service-frontend.pages.home.files-view :refer [files-view]]
   [file-service-frontend.templates.all :refer [all-template]]))
=======
(ns board-frontend.pages.home
  (:require
   [reagent.core :as r :refer [atom]]
   [board-frontend.states.globals :as sglobals]
   [board-frontend.actions.globals :as aglobals]
   [board-frontend.api :as api]
   [board-frontend.components.loading :refer [loading]]
   [board-frontend.pages.home.toolbar :refer [toolbar]]
   [board-frontend.pages.home.modal-add-file :refer [modal-add-file]]
   [board-frontend.pages.home.modal-file-view :refer [modal-file-view]]
   [board-frontend.pages.home.pathbar :refer [pathbar]]
   [board-frontend.pages.home.files-view :refer [files-view]]
   [board-frontend.templates.all :refer [all-template]]))
>>>>>>> 16da94029af601b261a8d7327a4192831e1db31c

(defn home-page [{:keys []}]
(r/create-class {
  :component-will-mount (fn [this]
    ;cargar paths iniciales
    (aglobals/set-loading true)
    (api/start-paths (fn [paths]
      (aglobals/set-paths (vec (reverse paths))))))
  :reagent-render (fn []
    [all-template
      [toolbar]
      [pathbar]
      [:div.container.pt-4
        [files-view]]
      [loading @sglobals/loading]
      [modal-file-view]
      [modal-add-file]])
}))