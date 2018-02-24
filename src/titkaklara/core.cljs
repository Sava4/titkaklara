(ns titkaklara.core
    (:require [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))


(defn hello-world []
  [:div
   [:h1 (:text @app-state)]
   [:h3 "Edit this and watch it change!"]])

(defn pirojok []
  [:div.tile.is-4.is-parent
    [:div.tile.is-child.box
      [:div.content
        [:p [:strong "Пирожок с персиком"]]
        [:nav.level.is-mobile
          [:div.level-left
            [:div.level-item
              [:a.level-item [:span.icon.is-small [:i.fas.fa-heart]]]
              [:p.level-item [:strong "15" " ₴"]]]]
          [:div.level-right
            [:div.level-item
              [:a.button.is-primary [:span [:strong "В корзину "] 
                                          [:i.fas.fa-shopping-cart]]]]]]]]])


(defn menu []
  [:div.tile.is-ancestor
    [pirojok]
    [pirojok]
    [pirojok]])                                         

;; FOR to generate rows from menu items
;; Map of menu items for state

(reagent/render-component [menu]
                          (. js/document (getElementById "app")))

(defn on-js-reload [])
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)

