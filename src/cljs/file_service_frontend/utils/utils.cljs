(ns board-frontend.utils
  (:require [clojure.string :as str]))

(defn cut-name [name cant]
  (str (.substring name 0 cant) (if (> (count name) cant) "...")))

(defn get-ext [file-name]
  (let [len (count file-name)]
    (.substring file-name (- len (if (> len 3) 4 len)) len)))

(defn get-type [ext]
  (case (clojure.string/lower-case ext)
    (".jpg" ".png" "jpeg") "picture"
    (".avi" ".mp4" ".mkv" ".mpg" "mpeg") "video"
    (".mp3" ".wmv") "sound"
    (".txt" ".ini" ".bat") "text"
    (".zip" ".rar") "compressed"
    (".pdf") "pdf"
    (".doc" "docx" ".odt") "word"
    (".xls" "xlsx" ".ods") "excel"
    (".ppt" "pptx" ".pps" ".odp") "powerpoint"
    "nil"))

(defn get-icon [file-name]
  (let [ext (get-ext file-name)]
    (case (get-type ext)
      "picture" "fa-file-image-o"
      "video" "fa-file-video-o"
      "sound" "fa-file-sound-o"
      "compressed" "fa-file-archive-o"
      "pdf" "fa-file-pdf-o"
      "word" "fa-file-word-o"
      "powerpoint" "fa-file-powerpoint-o"
      "excel" "fa-file-excel-o"
      "fa-file")))

(defn sorted-files [files-list]
  (let [folders (filter :isDirectory files-list)
    files (filter :isFile files-list)]
    (vec (concat 
      (sort (fn [a b] (< (:name a) (:name b))) folders)
      (sort (fn [a b] (< (:name a) (:name b))) files)))))