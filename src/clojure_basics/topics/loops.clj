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

(print-numbers)                                             ; prints 0 to 9

; dotimes — repeats a body n times, x goes from 0 to n-1
(defn print-first-five
  "Prints numbers from 0 to 4 using dotimes."
  []
  (dotimes [x 5]
    (println x)))

(print-first-five)                                          ; prints 0 1 2 3 4