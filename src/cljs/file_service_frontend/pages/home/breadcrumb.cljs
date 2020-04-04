<<<<<<< HEAD
(ns file-service-frontend.pages.home.breadcrumb
  (:require
    [file-service-frontend.utils :as utils]
    [file-service-frontend.actions.globals :as aglobals]
    [file-service-frontend.states.globals :as sglobals]))
=======
(ns board-frontend.pages.home.breadcrumb
  (:require
    [board-frontend.utils :as utils]
    [board-frontend.actions.globals :as aglobals]
    [board-frontend.states.globals :as sglobals]))
>>>>>>> 16da94029af601b261a8d7327a4192831e1db31c

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
            