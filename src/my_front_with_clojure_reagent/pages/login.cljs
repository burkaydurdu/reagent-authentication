(ns my-front-with-clojure-reagent.pages.login
  [:require 
   [my-front-with-clojure-reagent.db :refer[api-url app-state set-item!]] 
   [antizer.reagent :as ant]
   [ajax.core :refer [GET POST]]
   [ajax.core :as ajax]
   [goog.dom :as dom]
   [reagent.core :as r]])

(def current-state (r/atom {:email "" :password ""}))

(declare log-submit)

(defn token []
  (-> @current-state :user :token))

(defn login-comp
  []
  [:div 
   [:div {:class ["bd-input-elem"]} 
    [:ant/input {:id "email"
                 :class ["bd-input"]
                 :placeholder "Email"
                 :on-change (fn [e] 
                              (swap! current-state assoc :email (.. e -target -value)))}]]
   [:div {:class ["bd-input-elem"]}
    [:ant/input {:id "password"
                 :class ["bd-input"]
                 :placeholder "Password"
                 :type "password"
                 :on-change #(swap! current-state assoc :password (-> % .-target .-value))}]]
   [:div.bd-input-elem 
    [:ant/button {:class ["bd-button"]
                  :on-click log-submit} "Login"]]])

(defn log-submit []
  (println current-state)
  (POST (str api-url "login") 
        {:headers {"Access-Control-Allow-Headers" "Content-Type"
                   "Access-Control-Allow-Origin" "*"} 
         :format  (ajax/json-request-format)
         :params @current-state
         :handler (fn [r] (
                           (swap! app-state assoc :user r)
                           (set-item! "currentUser" r )
                           (prn r)
                           ;(set! (.-value (dom/getElement "email")) " ")
                           ;(set! (.-value (dom/getElement "password")) " ")
                           ))
         :error-handler (fn [r] (prn r))
         :response-format :json
         :keywords? true}))

(defn login []
  [:div {:class ["bd-box"]
         :style {:color "black"}}     
   [:h2 "Login Page"]
   [login-comp]
   [ant/button {:on-click #(ant/message-info (token))} "Click me"]])
