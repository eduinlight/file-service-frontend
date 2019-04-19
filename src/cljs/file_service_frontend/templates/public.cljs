(ns board-frontend.templates.all
  (:require [reagent.core :as r :refer [atom]]))

;TEST DE TEMPLATE (SOLO PARA COMPROBAR FUNCIONAMIENTO DE children y fragment)
(defn all-template [{:keys []}]
  (r/create-class {
    :component-will-mount (fn [this]
      (println "test de component will mount"))
    :reagent-render (fn []
      (into [:<>] (r/children (r/current-component))))
  }))