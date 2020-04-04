(ns file-service-frontend.prod
  (:require [file-service-frontend.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
