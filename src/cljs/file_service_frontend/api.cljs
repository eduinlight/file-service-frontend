(ns file-service-frontend.api
  (:require
   [ajax.core :as http]
   [file-service-frontend.config :as config]
   ))

(defn error-handler [error]
  println error)

(defn list-files [dir success]
  (http/GET (str config/api-url "/files/list")
   {:params {:dir dir}
    :handler success
    :error-handler error-handler
    :request-format :json
    :response-format :json
    :keywords? true}))

(defn start-paths [success]
  (http/GET (str config/api-url "/start_paths")
   {:params {}
    :handler success
    :error-handler error-handler
    :request-format :json
    :response-format :json
    :keywords? true}))
