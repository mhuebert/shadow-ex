(ns shadow-ex.eval
  (:require [kitchen-async.promise :as p]
            [shadow.cljs.bootstrap.browser :as boot]
            [clojure.set]
            [cljs.js :as cljs]))

;;;;;;;;;;;;;;;;;;;
;;
;; Set up bootstrap

(def bootstrap-path "/js/bootstrap")

(defonce c-state (cljs/empty-state))

(def init
  (delay
   (p/promise [resolve reject]
     (boot/init
      c-state
      {:path bootstrap-path
       :load-on-init '#{shadow-ex.core}}
      resolve))))

(defn eval-form
  "eval `form`, returns promise"
  [form]
  (p/promise [resolve reject]
    (p/do @init
          (cljs/eval c-state form
                     {:eval cljs/js-eval
                      :context :expr
                      :ns 'shadow-ex.core}
                     resolve))))
