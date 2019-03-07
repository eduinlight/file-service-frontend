(ns file-service-frontend.actions.globals
  (:require
    [file-service-frontend.states.globals :as sglobals]))

;file-selected
(defn set-file-selected [file]
  (reset! sglobals/file-selected file))

(defn unselect-file-selected []
  (reset! sglobals/file-selected nil))

;files list
(defn set-files [files]
  (reset! sglobals/files files))

;files paths
(defn set-paths [paths]
  (reset! sglobals/paths paths))

(defn push-paths [path]
  (swap! sglobals/paths conj path))

(defn pop-paths []
  (swap! sglobals/paths pop ))

(defn cut-paths [pos]
  (swap! sglobals/paths #(vec (take (inc pos) %))))