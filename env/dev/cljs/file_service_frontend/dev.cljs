(ns ^:figwheel-no-load file-service-frontend.dev
  (:require
    [file-service-frontend.core :as core]
    [devtools.core :as devtools]))

(devtools/install!)

(enable-console-print!)

(core/init!)
