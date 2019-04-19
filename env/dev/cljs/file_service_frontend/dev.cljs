(ns ^:figwheel-no-load board-frontend.dev
  (:require
    [board-frontend.core :as core]
    [devtools.core :as devtools]))

(devtools/install!)

(enable-console-print!)

(core/init!)
