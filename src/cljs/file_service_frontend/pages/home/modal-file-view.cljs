<<<<<<< HEAD
(ns file-service-frontend.pages.home.modal-file-view
  (:require
   [file-service-frontend.utils :as utils]
   [file-service-frontend.config :as config]
   [file-service-frontend.api :as api]
   [file-service-frontend.actions.globals :as aglobals]
   [file-service-frontend.states.globals :as sglobals]))
=======
(ns board-frontend.pages.home.modal-file-view
  (:require
   [board-frontend.utils :as utils]
   [board-frontend.config :as config]
   [board-frontend.api :as api]
   [board-frontend.actions.globals :as aglobals]
   [board-frontend.states.globals :as sglobals]))
>>>>>>> 16da94029af601b261a8d7327a4192831e1db31c

(defn btn-close-click []
  (aglobals/set-modal-file-view false))

(defn modal-file-view []
  (let [open @sglobals/modal-file-view]
    (if (and open (not (nil? @sglobals/file-selected)))
      [:div.modal.fade {:class (if open "in d-block") 
        :on-click #(btn-close-click)}
        [:div.modal-dialog {:on-click #(.stopPropagation %)}
          [:div.modal-content
            [:div.modal-header
              [:h4.modal-title
                "Visualizar archivo"]]
            [:div.modal-body
            (let [
                file-text (atom "")
                {:keys [name path]} @sglobals/file-selected
                ext (utils/get-ext name)
                file-url (str config/api-url "/files/download?path=" path)]
              (case (utils/get-type ext)
                "picture" [:img.img-viewer {:src file-url}]
                "video" [:video.img-viewer {:src file-url :autoPlay true :controls true}]
                "sound" [:video.img-viewer {:src file-url :autoPlay true :controls true}]
                "text" [:iframe.iframe-viewer {:src file-url}]
                "nil" [:div.alert.alert-info "Archivo no soportado"]
                ))]
            [:div.modal-footer
              [:button.btn.btn-default {:type "button" :on-click #(btn-close-click)}
                "Cerrar"]
              ]]]])))
        