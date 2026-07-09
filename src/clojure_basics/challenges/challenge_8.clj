(ns clojure-basics.challenges.challenge-8)

; Challenge: employee bonus calculator
; Concepts: cond, map, filter, reduce, defn
; This combines conditionals with the map/filter/reduce trio from challenge 7 —
; the bonus rate is decided with cond, then applied across the whole collection.
;
; Requirements:
; 1. Define a vector `employees` with at least 5 maps, each with :name and :salary
; 2. Write bonus-rate using cond — returns a bonus percentage based on salary:
;    - salary < 2000            -> 5
;    - salary < 5000            -> 10
;    - salary < 10000           -> 15
;    - otherwise                -> 20
; 3. Write add-bonus using map:
;    - takes a collection of employees
;    - returns a new collection where each employee map has a :bonus key added,
;      computed as (salary * bonus-rate) / 100
; 4. Write top-earners using filter:
;    - takes a collection of employees (with :bonus already added) and a threshold
;    - returns only the employees whose :bonus is >= threshold
; 5. Write total-bonus-payout using reduce:
;    - takes a collection of employees (with :bonus already added)
;    - returns the sum of all their :bonus values
; 6. Call each function below and check the printed results against the comments

(def employees [{:name "Alice" :salary 1800}
                {:name "Bob" :salary 3200}
                {:name "Carol" :salary 6000}
                {:name "Dave" :salary 12000}
                {:name "Eve" :salary 4500}])

(defn bonus-rate
  "Returns the bonus percentage for a given salary."
  [salary]
  (cond
    (< salary 2000) 5
    (< salary 5000) 10
    (< salary 10000) 15
    :else 20))

(defn add-bonus
  "Returns employees with a :bonus key added to each, based on bonus-rate."
  [employees]
  (map (fn [employee]
         (assoc employee :bonus (/ (* (:salary employee) (bonus-rate (:salary employee))) 100)))
       employees))

(defn top-earners
  "Returns only the employees whose :bonus is >= threshold."
  [employees threshold]
  (filter (fn [employee] (>= (:bonus employee) threshold)) employees))

(defn total-bonus-payout
  "Returns the sum of :bonus across all employees."
  [employees]
  (reduce + (map :bonus employees)))

; Try it out once implemented:
(def employees-with-bonus (add-bonus employees))
(println employees-with-bonus)                                        ; expect bonuses: Alice 90, Bob 320, Carol 900, Dave 2400, Eve 450
(println (top-earners employees-with-bonus 400))                      ; expect Carol, Dave, Eve
(println (total-bonus-payout employees-with-bonus))                   ; expect 4160
(println (total-bonus-payout (top-earners employees-with-bonus 400))) ; expect 3750