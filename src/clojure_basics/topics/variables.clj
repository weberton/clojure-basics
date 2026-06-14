(ns clojure-basics.topics.variables)

; Variables are immutable

; def creates a global var — available throughout the namespace
(def status true)
(println status)                                            ; prints true


; let binds local values — only available within its block
(let [name "Tom"
      age  30]
  (println name)                                            ; prints Tom
  (println age))                                            ; prints 30