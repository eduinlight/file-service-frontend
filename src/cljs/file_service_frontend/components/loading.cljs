<<<<<<< HEAD
(ns file-service-frontend.components.loading
=======
(ns board-frontend.components.loading
>>>>>>> 16da94029af601b261a8d7327a4192831e1db31c
  (:require
   [reagent.core :as r :refer [atom]]))

(defn loading [state]
  [:div#preloader {:class (if (not state) "d-none")}
    [:div#load]])