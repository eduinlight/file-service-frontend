(ns file-service-frontend.pages.home.files-view
  (:require
   [file-service-frontend.utils :as utils]
   [file-service-frontend.actions.globals :as aglobals]
   [file-service-frontend.states.globals :as sglobals]))

(defn select-file [f]
  (if (or (nil? @sglobals/file-selected) (not (= (:path @sglobals/file-selected) (:path f))))
    (aglobals/set-file-selected f)
    (aglobals/unselect-file-selected)))

(defn dir-click [dir]
  (aglobals/push-paths {:path (:path dir) :name (:name dir)}))

(defn file-click [f]
  (if (not (and (not (nil? @sglobals/file-selected)) (= (:path f) (:path @sglobals/file-selected))))
    (select-file f))
  (aglobals/set-modal-file-view true))

(defn file-label [f]
  [:h5 {:title (str "Seleccionar " (:name f))
    :on-click #(select-file f)
    :class (if (= (:path @sglobals/file-selected) (:path f) ) "selected")} 
    (utils/cut-name (:name f) 40)])

(defn file-component [f]
  [:div.file 
    [:i.fa.file-color {:title "Ver archivo" 
      :on-click #(file-click f)
      :class (utils/get-icon (:name f))}]
    (file-label f)])

(defn dir-component [d]
  [:div.file
    [:i.fa.fa-folder.dir-color {:title "Abrir"
      :on-click #(dir-click d)}]
    (file-label d)])

(defn files-view []
  [:div.row
    (if (not (empty? @sglobals/files))
      (do
      (for [file @sglobals/files]
        [:div.col-xs-4.col-md-2 {:key (:name file)}
          (if (:isDirectory file)
            [dir-component file]
            [file-component file])]))
      [:div.col-xs-12>div.alert.alert-info "La carpeta esta vacía"])])
      