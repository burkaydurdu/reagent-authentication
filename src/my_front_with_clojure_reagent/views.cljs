(ns my-front-with-clojure-reagent.views
  [:require
   [my-front-with-clojure-reagent.pages.home :refer [home]]
   [my-front-with-clojure-reagent.pages.about :refer [about]]
   [my-front-with-clojure-reagent.pages.login :refer [login]]
   [my-front-with-clojure-reagent.components.navbar :refer [navbar]]
   [my-front-with-clojure-reagent.db :refer[app-state]]])

(defmulti current-page #(@app-state :page))

(defmethod current-page :home []
  [:div
   [navbar]
   [home]])

(defmethod current-page :about []
  [:div
   [navbar]
   [about]])

(defmethod current-page :login []
  [:div
   [navbar]
   [login]])

(defmethod current-page :default []
  [:div "default"])


