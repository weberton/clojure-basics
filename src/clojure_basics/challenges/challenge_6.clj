(ns clojure-basics.challenges.challenge-6)

; Challenge: movie ticket pricing
; Concepts: if, cond, case, defn
;
; Requirements:
; 1. Write ticket-base-price using cond:
;    - age < 5          -> 0 (free)
;    - age < 18          -> 8
;    - age >= 65         -> 6
;    - otherwise         -> 12
; 2. Write day-surcharge using case on a day keyword (:mon :tue :wed :thu :fri :sat :sun):
;    - :sat or :sun      -> 3
;    - any weekday        -> 0
;    (hint: case can match a set of keys in one clause: (:sat :sun) 3)
; 3. Write ticket-price that combines both: (+ base-price surcharge),
;    using if to print "Free entry" instead of a price when the base price is 0
; 4. Call ticket-price for a few different ages and days to check your results

(defn ticket-base-price
  "Returns the base ticket price for a given age."
  [age]
  (cond
    (< age 5) 0
    (< age 18) 8
    (>= age 65) 6
    :else 12))

(defn day-surcharge
  "Returns the surcharge for a given day keyword."
  [day]
  (case day
    (:mon :tue :wed :thu :fri) 0
    (:sat :sun) 3))

(defn ticket-price
  "Prints the final ticket price for a given age and day, or 'Free entry' if the base price is 0."
  [age day]
  (let [ticket-price-per-age (ticket-base-price age)
        surcharge (day-surcharge day)]
    (if (= ticket-price-per-age 0)
      (println "Free entry")
      (println "Entry:" (+ ticket-price-per-age surcharge)))))

; Try it out once implemented:
(ticket-price 4 :sat)                                       ; expect "Free entry"
(ticket-price 10 :tue)                                      ; expect 8
(ticket-price 30 :sun)                                      ; expect 15
(ticket-price 70 :fri)                                      ; expect 6