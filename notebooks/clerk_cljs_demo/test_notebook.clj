(ns clerk-cljs-demo.test-notebook
  (:require [nextjournal.clerk :as clerk]))

;; Define a viewer to format Lisp functions
(defn lisp-code-viewer [label code]
  [:div {:style {:border "1px solid #ccc" :margin "10px" :padding "10px"}}
   [:h2 label]
   [:pre code]])

;; Define a viewer to format comments
(defn comment-viewer [label comment]
  [:div {:style {:margin "10px"}}
   [:h3 label]
   [:p comment]])

;; Function Definitions
(clerk/with-viewer
  '(fn [_ _]
     (comment-viewer "Introduction" "This notebook demonstrates some LISP primitives and combinators with light styling.")
     (lisp-code-viewer "atom?" "(defn atom? [x] (not (coll? x)))")
     (lisp-code-viewer "eq?" "(defn eq? [x y] (= x y))")
     (lisp-code-viewer "car" "(defn car [x] (first x))")
     (lisp-code-viewer "cdr" "(defn cdr [x] (rest x))")
     (lisp-code-viewer "cons" "(defn cons [x y] (conj y x))")
     (lisp-code-viewer "list" "(defn list [& xs] xs)")
     (lisp-code-viewer "cond" "(defmacro cond [& clauses] `(if ~(first clauses) ~(second clauses) (cond ~@(drop 2 clauses))))")
     (lisp-code-viewer "null?" "(defn null? [x] (empty? x))")
     (lisp-code-viewer "and" "(defmacro and [& args] `(if ~(first args) (and ~@(rest args)) false))")
     (lisp-code-viewer "or" "(defmacro or [& args] `(if ~(first args) true (or ~@(rest args))))")
     (lisp-code-viewer "not" "(defn not [x] (if x false true))")
     (comment-viewer "Closing Note" "These are basic LISP primitives and combinators defined in Clojure."))
  nil)
