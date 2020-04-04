<<<<<<< HEAD
(ns file-service-frontend.pages.home.modal-add-file
  (:require
   [file-service-frontend.actions.globals :as aglobals]
   [file-service-frontend.states.globals :as sglobals]))
=======
(ns board-frontend.pages.home.modal-add-file
  (:require
   [board-frontend.actions.globals :as aglobals]
   [board-frontend.states.globals :as sglobals]))
>>>>>>> 16da94029af601b261a8d7327a4192831e1db31c

(defn btn-add-file-click []
  (aglobals/set-modal-add-file-open false))

(defn modal-add-file []
  (let [open @sglobals/modal-add-file-open
    
    ]
    [:div.modal.fade {:class (if open "in d-block") :on-click #(btn-add-file-click)}
      [:div.modal-dialog {:on-click #(.stopPropagation %)}
        [:div.modal-content
          [:div.modal-header
            [:h4.modal-title
              "Crear nuevo archivo"]]
          [:div.modal-body
            "aca contenido"]
          [:div.modal-footer
            [:button.btn.btn-default {:type "button" :on-click #(btn-add-file-click)}
              "Cerrar"]
            [:button.btn.btn-primary
              "Crear"]]]]]))
      