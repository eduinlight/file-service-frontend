(ns file-service-frontend.pages.home
  (:require
   [reagent.core :as r :refer [atom]]
   [file-service-frontend.states.globals :as sglobals]
   [file-service-frontend.actions.globals :as aglobals]
   [file-service-frontend.api :as api]
   [file-service-frontend.pages.home.toolbar :refer [toolbar]]
   [file-service-frontend.pages.home.pathbar :refer [pathbar]]
   [file-service-frontend.pages.home.files-view :refer [files-view]]
   [file-service-frontend.templates.all :refer [all-template]]))

(defn home-page [{:keys []}]
(r/create-class {
  :component-will-mount (fn [this]
    ;cargar paths iniciales
    (api/start-paths (fn [paths]
      (aglobals/set-paths (vec (reverse paths))))))
  :reagent-render (fn []
    [all-template
      [toolbar]
      [pathbar]
      [:div.container.pt-4
        [files-view]]])
}))