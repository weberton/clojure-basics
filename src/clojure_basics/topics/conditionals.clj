(ns clojure-basics.topics.conditionals
  (:require [nrepl.misc :refer [returning]]))

; if: (if condition then else)
; the else branch is optional
; each branch accepts only one expression — use (do ...) for multiple expressions

(defn even-number?
  "Prints whether x is even or odd."
  [x]
  (if (= (rem x 2) 0)
    (println "Even number")                                 ; then — condition is true
    (println "Odd number")))                                ; else — condition is false

(even-number? 4)                                            ; prints Even number
(even-number? 7)                                            ; prints Odd number

; if with do — allows multiple expressions per branch
(defn adult?
  "Prints permissions based on whether the person is an adult."
  [age]
  (if (>= age 18)
    (do (println "Adult: access granted")
        (println "You can vote")
        (println "You can drive"))
    (do (println "Minor: access restricted")
        (println "You cannot vote yet"))))

(adult? 20)                                                 ; prints Adult: access granted, You can vote, You can drive
(adult? 15)                                                 ; prints Minor: access restricted, You cannot vote yet

; if with or — free entry for children, seniors, or staff
(defn free-entry?
  "Prints whether the person gets free entry based on age or staff status."
  [age is-staff?]
  (if (or (< age 12) (>= age 65) is-staff?)
    (println "Free entry")
    (println "Please pay")))

(free-entry? 8 false)                                       ; prints Free entry — child
(free-entry? 70 false)                                      ; prints Free entry — senior
(free-entry? 30 true)                                       ; prints Free entry — staff
(free-entry? 30 false)                                      ; prints Please pay


; case — matches an exact value, like a switch in other languages
(defn day-of-week
  "Prints the day name for a given day number (1 = Sunday, 7 = Saturday)."
  [day]
  (case day
    1 (println "Sunday")
    2 (println "Monday")
    3 (println "Tuesday")
    4 (println "Wednesday")
    5 (println "Thursday")
    6 (println "Friday")
    7 (println "Saturday")))

(day-of-week 1)                                             ; prints Sunday
(day-of-week 6)                                             ; prints Friday


; cond — evaluates conditions in order, returns the value of the first matching branch
(defn calculate-discount
  "Returns the discount percentage based on the total price."
  [total-price]
  (cond
    (< total-price 50)  0
    (< total-price 100) 10
    (< total-price 200) 20
    :else               30))

(println (calculate-discount 30))                           ; prints 0
(println (calculate-discount 75))                           ; prints 10
(println (calculate-discount 150))                          ; prints 20
(println (calculate-discount 250))                          ; prints 30