(ns file-service-frontend.pages.home.breadcrumb
  (:require
   [reagent.core :as r :refer [atom]]
   [file-service-frontend.actions.globals :as aglobals]
   [file-service-frontend.api :as api]
   [file-service-frontend.utils :as utils]
   [file-service-frontend.states.globals :as sglobals]))

(defn dir-click [pos path]
  (aglobals/cut-paths pos))

(defn breadcrumb []
  [:ol.breadcrumb.mb-0
    (for [i (range (count @sglobals/paths))]
      (let [{:keys [name path]} (nth @sglobals/paths i)]
        (do
          [:li {:key i 
                :class (if (= i (-> @sglobals/paths count dec)) "active")
                :disabled (= i (-> @sglobals/paths count dec))
                :on-click #(dir-click i path)}
            (utils/cut-name (if (= name "") path name) 30)])))])
            