(ns board-frontend.core
  (:require
   [reagent.core :as r :refer [atom]]
   [board-frontend.pages.home :refer [home-page]]))

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
