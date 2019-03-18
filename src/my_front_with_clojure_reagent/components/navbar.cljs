(ns my-front-with-clojure-reagent.components.navbar
  (:require 
     [antizer.reagent :as ant]
     [my-front-with-clojure-reagent.db :refer[app-state get-item remove-item!]]))

(defn remove-user []
  (remove-item! "currentUser")
  (swap! app-state assoc :user nil))

(defn navbar []
  [:div#sidebar-wrapper
   [:ul.sidebar-nav
   (if-not (or (-> @app-state :user) (get-item "currentUser")) 
     [:li.sidebar-brand>a {:href "/#/login"} "Login"])
    [:li>a {:href "/#/"} "Home"]
    [:li>a {:href "/#/about"} "About"]
    (if (or (-> @app-state :user) (get-item "currentUser"))
      [:li>a { :on-click #(remove-user)} "Logout"])]])
