(ns shadow-ex.core
  (:require [shadow-ex.eval :as e]
            [applied-science.js-interop :as j]
            [kitchen-async.promise :as p])
  (:require-macros [shadow-ex.macros :as m]))

;; eval whenever this page is refreshed

(defn ^:dev/after-load ^:export eval-example []
  (p/let [form `(m/current-time)
          result (e/eval-form form)]
    (-> (js/document.getElementById "ex")
        (j/update! :innerHTML str
                   (prn-str "other: " form :=> (:value result))
                   "<br/>"))))
