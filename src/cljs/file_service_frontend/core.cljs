(ns file-service-frontend.core
  (:require
   [reagent.core :as r :refer [atom]]
   [file-service-frontend.pages.home :refer [home-page]]))

(defn mount-root []
  (r/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
