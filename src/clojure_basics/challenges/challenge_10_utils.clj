(ns clojure-basics.challenges.challenge-10-utils)

; Support namespace for challenge_10.clj — pure conversion/classification
; helpers with no readings, atoms, or printing of their own. This file is
; meant to be required, not run directly.
;
; Requirements:
; 1. Write celsius->fahrenheit:
;    - takes a temperature in celsius
;    - returns it converted to fahrenheit: (celsius * 9/5) + 32
;    - use 9.0/5 (not 9/5) so the result is a double, not a fraction
; 2. Write classify-temp using cond:
;    - takes a temperature in fahrenheit
;    - returns a classification string based on it:
;      - f < 32            -> "freezing"
;      - f < 60            -> "cold"
;      - f < 80            -> "mild"
;      - otherwise         -> "hot"

(defn celsius->fahrenheit
  [c]
  (+ (* c (/ 9.0 5)) 32))

(defn classify-temp
  [f]

  )
