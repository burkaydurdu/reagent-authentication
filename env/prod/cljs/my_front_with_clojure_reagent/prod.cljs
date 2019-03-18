(ns my-front-with-clojure-reagent.prod
  (:require
    [my-front-with-clojure-reagent.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
