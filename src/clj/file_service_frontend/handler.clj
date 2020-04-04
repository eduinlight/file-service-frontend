<<<<<<< HEAD
(ns file-service-frontend.handler
  (:require
   [reitit.ring :as reitit-ring]
   [file-service-frontend.middleware :refer [middleware]]
=======
(ns board-frontend.handler
  (:require
   [reitit.ring :as reitit-ring]
   [board-frontend.middleware :refer [middleware]]
>>>>>>> 16da94029af601b261a8d7327a4192831e1db31c
   [hiccup.page :refer [include-js include-css html5]]
   [config.core :refer [env]]))

(def mount-target
  [:div#app
<<<<<<< HEAD
   [:h2 "Welcome to file-service-frontend"]
=======
   [:h2 "Welcome to board-frontend"]
>>>>>>> 16da94029af601b261a8d7327a4192831e1db31c
   [:p "please wait while Figwheel is waking up ..."]
   [:p "(Check the js console for hints if nothing exсiting happens.)"]])

(defn head []
  [:head
   [:meta {:charset "utf-8"}]
   [:meta {:name "viewport"
           :content "width=device-width, initial-scale=1"}]
   (include-css (if (env :dev) "/css/site.css" "/css/site.min.css"))])

(defn loading-page []
  (html5
   (head)
   [:body {:class "body-container"}
    mount-target
    (include-js "/js/app.js")]))

(defn index-handler
  [_request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (loading-page)})

(def app
  (reitit-ring/ring-handler
   (reitit-ring/router
    [["/" {:get {:handler index-handler}}]
     ["/items"
      ["" {:get {:handler index-handler}}]
      ["/:item-id" {:get {:handler index-handler
                          :parameters {:path {:item-id int?}}}}]]
     ["/about" {:get {:handler index-handler}}]])
   (reitit-ring/routes
    (reitit-ring/create-resource-handler {:path "/" :root "/public"})
    (reitit-ring/create-default-handler))
   {:middleware middleware}))
