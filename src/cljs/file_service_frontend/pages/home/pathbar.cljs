(ns board-frontend.pages.home.pathbar
  (:require
   [board-frontend.pages.home.breadcrumb :refer [breadcrumb]]
   [board-frontend.actions.globals :as aglobals]
   [board-frontend.states.globals :as sglobals]))

(defn btn-up-click []
  (if (and (> (count @sglobals/paths) 1) (not @sglobals/loading))
    (aglobals/pop-paths)))

(defn btn-refresh-click []
  (sglobals/update-path (:path (last @sglobals/paths))))

(defn pathbar []
  [:div.d-flex.flex-row.align-items-center.header.dir
    [:button.button {:disabled (= 1 (count @sglobals/paths))
      :on-click #(btn-up-click)
      :title "Ir a directorio superior"}
      [:i.fa.fa-arrow-up]]
    [:button.button {
      :on-click #(btn-refresh-click)
      :title "Actualizar"}
      [:i.fa.fa-refresh]]
    [:div.separator]
    [breadcrumb]])
      