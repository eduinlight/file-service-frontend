(ns file-service-frontend.utils
  (:require [clojure.string :as str]))

(defn cut-name [name cant]
  (str (.substring name 0 cant) (if (> (count name) cant) "...")))

(defn get-ext [file-name]
  (let [len (count file-name)]
    (.substring file-name (- len (if (> len 3) 4 len)) len)))

(defn get-icon [file-name]
  (let [ext (get-ext file-name)]
    (case (clojure.string/lower-case ext)
      ".jpg" "fa-file-image-o"
      ".png" "fa-file-image-o"
      "jpeg" "fa-file-image-o"
      ".avi" "fa-file-video-o"
      ".mp4" "fa-file-video-o"
      ".mkv" "fa-file-video-o"
      ".mpg" "fa-file-video-o"
      "mpeg" "fa-file-video-o"
      ".mp3" "fa-file-sound-o"
      ".wmv" "fa-file-sound-o"
      ".zip" "fa-file-archive-o"
      ".rar" "fa-file-archive-o"
      ".pdf" "fa-file-pdf-o"
      ".doc" "fa-file-word-o"
      "docx" "fa-file-word-o"
      ".odt" "fa-file-word-o"
      ".ppt" "fa-file-powerpoint-o"
      ".pps" "fa-file-powerpoint-o"
      "pptx" "fa-file-powerpoint-o"
      ".odp" "fa-file-powerpoint-o"
      ".xls" "fa-file-excel-o"
      "xlsx" "fa-file-excel-o"
      ".ods" "fa-file-excel-o"
      "fa-file")))

(defn sorted-files [files-list]
  (let [folders (filter :isDirectory files-list)
    files (filter :isFile files-list)]
    (vec (concat 
      (sort (fn [a b] (< (:name a) (:name b))) folders)
      (sort (fn [a b] (< (:name a) (:name b))) files)))))