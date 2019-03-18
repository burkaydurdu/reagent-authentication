(ns my-front-with-clojure-reagent.core
    (:require
      [reagent.core :as r]
      [my-front-with-clojure-reagent.routes :refer [app-routes]]
      [my-front-with-clojure-reagent.views :refer[current-page]]))

;; [ant/button {:on-click #(ant/message-info "Hello Reagent!")} "Click me"])

;; -------------------------
;; Initialize app

(defn mount-root []  
  (app-routes)
  (r/render [current-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
