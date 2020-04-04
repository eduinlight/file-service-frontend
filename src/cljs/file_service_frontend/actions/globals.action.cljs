(ns file-service-frontend.actions.globals
  (:require
    [file-service-frontend.states.globals :as sglobals]))

;loading
(defn set-loading [val]
  (reset! sglobals/loading val))

;modal-add-file-open
(defn set-modal-add-file-open [val]
  (reset! sglobals/modal-add-file-open val))

;modal-file-view
(defn set-modal-file-view [val]
  (reset! sglobals/modal-file-view val))

;modal-add-folder-open
(defn set-modal-add-folder-open [val]
  (reset! sglobals/modal-add-folder-open val))

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