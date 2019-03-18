(ns ^:figwheel-no-load my-front-with-clojure-reagent.dev
  (:require
    [my-front-with-clojure-reagent.core :as core]
    [devtools.core :as devtools]))


(enable-console-print!)

(devtools/install!)

(core/init!)
