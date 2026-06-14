(ns clojure-basics.topics.functions)

(defn basic-function
  "My first basic function. It creates two expressions to print text and returns the result of the last expression.
  Functions always return something - the last expression's value, or nil."
  []                                                        ;No params
  (println "My name is Tom")                                ; Expression 1
  (println "I am learning clojure")                         ; Expression 2
  (+ 1 10)                                                  ; Returns 11 (result of the last expression)
  )


; defn is the keyword that creates a named function
; def assigns an anonymous function (fn) to a name
; Now we can use increment by name inside other functions
(def increment (fn [x] (+ x 1)))

(defn increment-set
  [x]                                                       ; receives a param
  (increment x)                                             ; calls increment with x
  )