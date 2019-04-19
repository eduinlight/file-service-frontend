(ns board-frontend.api
  (:require
   [ajax.core :as http]
   [board-frontend.config :as config]
  ;  [board-frontend.actions.globals :as aglobals]
   ))

(defn error-handler [error]
  ; (aglobals/set-loading false)
  (println error))

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

(defn get-content [path success]
  (http/GET (str config/api-url "/files/content")
   {:params {:path path}
    :handler success
    :error-handler error-handler
    :request-format :json
    :response-format :json
    :keywords? true}))
