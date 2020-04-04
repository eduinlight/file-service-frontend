<<<<<<< HEAD
(ns file-service-frontend.pages.home.toolbar
  (:require
   [file-service-frontend.actions.globals :as aglobals]
   [file-service-frontend.states.globals :as sglobals]))
=======
(ns board-frontend.pages.home.toolbar
  (:require
   [board-frontend.actions.globals :as aglobals]
   [board-frontend.states.globals :as sglobals]))
>>>>>>> 16da94029af601b261a8d7327a4192831e1db31c

(defn btn-up-click []
  (if (> (count @sglobals/paths) 1)
    (aglobals/pop-paths)))

(defn btn-new-file-click []
  (aglobals/set-modal-add-file-open true))

(defn toolbar []
  [:div.d-flex.flex-row.align-items-center.header.toolbar
    [:button.button {
      :class (if (= 1 (count @sglobals/paths)) "disabled")
      :on-click #(btn-up-click)
      :title "Crear nueva carpeta"}
      [:i.fa.fa-folder]]
    [:button.button {
      :on-click #(btn-new-file-click)
      :title "Crear nuevo archivo"}
      [:i.fa.fa-file]]
    [:div.separator]
    [:button.button {:disabled (nil? @sglobals/file-selected)
      :on-click #(btn-up-click)
      :title "Cambiar nombre"}
      [:i.fa.fa-edit]]
    [:button.button {:disabled (nil? @sglobals/file-selected) 
      :on-click #(btn-up-click)
      :title "Eliminar"}
      [:i.fa.fa-trash]]
    [:div.logo-right
      "FILE SERVICE EDUIN"]])
      