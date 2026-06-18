(ns clojure-basics.topics.atoms)


; atoms — Clojure's way to manage mutable state
; unlike regular values, atoms can be updated over time

(defn atoms-example
  "Demonstrates how to declare, read, and update an atom."
  []
  (let [amount (atom 100)]        ; declare an atom with initial value 100
    (println @amount)             ; @ dereferences the atom — prints 100
    (swap! amount + 50)           ; swap! updates the value: amount = amount + 50
    (println @amount)             ; prints 150
    (reset! amount 0)             ; reset! sets a completely new value
    (println @amount)))           ; prints 0

(println "--- atoms-example ---")
(atoms-example)


; compare-and-set! — updates the atom only if the current value matches the expected value
; returns true if updated, false if not
(defn compare-and-set-example
  "Demonstrates compare-and-set! — a safe conditional update."
  []
  (let [amount (atom 100)]
    (println (compare-and-set! amount 100 120)) ; true  — value was 100, now 200
    (println @amount)                           ; prints 120
    (println (compare-and-set! amount 110 115)) ; false — value is 120, not 110
    (println @amount)))                         ; prints 120 — unchanged

(println "--- compare-and-set-example ---")
(compare-and-set-example)