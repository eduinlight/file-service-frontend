(ns board-frontend.pages.home.breadcrumb
  (:require
    [board-frontend.utils :as utils]
    [board-frontend.actions.globals :as aglobals]
    [board-frontend.states.globals :as sglobals]))

(defn dir-click [pos path]
  (if (and (< pos (-> @sglobals/paths count dec)) (not @sglobals/loading))
    (aglobals/cut-paths pos)))

(defn breadcrumb []
  [:ol.breadcrumb.mb-0
    (for [i (range (count @sglobals/paths))]
      (let [{:keys [name path]} (nth @sglobals/paths i)]
        (do
          [:li {:key i 
                :class (if (= i (-> @sglobals/paths count dec)) "active")
                :on-click #(dir-click i path)}
            (utils/cut-name (if (= name "") path name) 30)])))])
            