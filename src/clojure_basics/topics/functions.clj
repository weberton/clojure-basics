(ns clojure-basics.topics.functions)

(defn basic-function
  "My first basic function. It creates two expressions to print text and returns the result of the last expression.
  Functions always return something - the last expression's value, or nil."
  []                                                        ;No params
  (println "My name is Tom")                                ; Expression 1
  (println "I am learning clojure")                         ; Expression 2
  (+ 1 10)                                                  ; Returns 11 (result of the last expression)
  )