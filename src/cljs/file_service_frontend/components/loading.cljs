(ns board-frontend.components.loading
  (:require
   [reagent.core :as r :refer [atom]]))

(defn loading [state]
  [:div#preloader {:class (if (not state) "d-none")}
    [:div#load]])