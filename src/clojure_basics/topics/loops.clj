(ns clojure-basics.topics.loops)

; loop/recur — the idiomatic way to loop in Clojure
; loop sets the initial bindings, recur jumps back to loop with new values
; when is used instead of if when there is no else branch

(defn print-numbers
  "Prints numbers from 0 to 9 using loop/recur."
  []
  (loop [x 0]                                               ; start x at 0
    (when (< x 10)
      (println x)
      (recur (inc x)))))                                    ; jump back to loop with x + 1

(println "--- print-numbers ---")
(print-numbers)                                             ; prints 0 to 9

; dotimes — repeats a body n times, x goes from 0 to n-1
(defn print-first-five
  "Prints numbers from 0 to 4 using dotimes."
  []
  (dotimes [x 5]
    (println x)))

(println "--- print-first-five ---")
(print-first-five)                                          ; prints 0 1 2 3 4


; while — loops while a condition is true, requires mutable state via atom
; atom is Clojure's way to manage mutable state
; @x dereferences the atom (reads its value), swap! updates it
(defn print-up-to
  "Prints numbers from 0 up to n (exclusive) using while."
  [n]
  (let [x (atom 0)]
    (while (< @x n)
      (println @x)
      (swap! x inc))))                                      ; increment x by 1

(println "--- print-up-to ---")
(print-up-to 5)                                             ; prints 0 1 2 3 4

; doseq — iterates over a collection, used for side effects (e.g. printing)
(defn print-collection
  "Prints each item in a collection using doseq."
  [items]
  (doseq [x items]
    (println x)))

(println "--- print-collection ---")
(print-collection ["A" "B" 3 4 5])                              ; prints 1 2 3 4 5

