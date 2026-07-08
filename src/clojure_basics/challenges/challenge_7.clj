(ns clojure-basics.challenges.challenge-7)

; Challenge: shopping cart totals
; Concepts: map, filter, reduce, defn
;
; Requirements:
; 1. Define a vector `prices` with at least 5 numbers (item prices)
; 2. Write apply-discount using map:
;    - takes a collection of prices and a discount percentage (e.g. 10 for 10%)
;    - returns a new collection with each price reduced by that percentage
; 3. Write affordable-items using filter:
;    - takes a collection of prices and a budget
;    - returns only the prices that are <= budget
; 4. Write total using reduce:
;    - takes a collection of prices
;    - returns the sum of all of them
; 5. Call each function below and check the printed results against the comments

(def prices [25 60 15 100 45])


(defn apply-discount
  "Returns prices with the given discount percentage applied to each."
  [prices discount-percent]
  (map (fn [price] (- price (/ (* price discount-percent) 100.0))) prices))

(defn affordable-items
  "Returns only the prices that are less than or equal to budget."
  [prices budget]
  (filter (fn [price] (<= price budget)) prices))

(defn total
  "Returns the sum of all prices."
  [prices]
  (reduce + prices))

; Try it out once implemented:
(println (apply-discount prices 10))                        ; expect (22.5 54.0 13.5 90.0 40.5)
(println (affordable-items prices 50))                      ; expect (25 15 45)
(println (total prices))                                    ; expect 245
(println (total (affordable-items prices 50)))              ; expect 85