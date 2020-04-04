<<<<<<< HEAD
(ns file-service-frontend.server
    (:require
     [file-service-frontend.handler :refer [app]]
=======
(ns board-frontend.server
    (:require
     [board-frontend.handler :refer [app]]
>>>>>>> 16da94029af601b261a8d7327a4192831e1db31c
     [config.core :refer [env]]
     [ring.adapter.jetty :refer [run-jetty]])
    (:gen-class))

(defn -main [& args]
  (let [port (or (env :port) 3000)]
    (run-jetty app {:port port :join? false})))
