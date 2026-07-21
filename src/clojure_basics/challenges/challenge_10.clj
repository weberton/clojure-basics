(ns clojure-basics.challenges.challenge-10
  (:require [clojure-basics.challenges.challenge-10-utils :as utils]))

; Challenge: weather station report
; Concepts: namespaces (require + :as), map, filter, reduce
; This is the first challenge split across two files. Implement
; challenge_10_utils.clj first — celsius->fahrenheit and classify-temp —
; then come back here and call them as utils/celsius->fahrenheit and
; utils/classify-temp.
;
; Requirements:
; 1. Define a vector `readings` with at least 5 celsius temperatures
;    (include some cold and some hot values, e.g. negatives and 30+)
; 2. Write convert-readings using map:
;    - takes a collection of celsius readings
;    - returns them converted to fahrenheit via utils/celsius->fahrenheit
; 3. Write classify-readings using map:
;    - takes a collection of fahrenheit readings
;    - returns their classification strings via utils/classify-temp
; 4. Write hot-days using filter:
;    - takes a collection of fahrenheit readings
;    - returns only the ones utils/classify-temp calls "hot"
; 5. Write average-temp using reduce:
;    - takes a collection of fahrenheit readings
;    - returns their average (sum / count)
; 6. Call each function below and check the printed results against the comments

(def readings [0 10 22 35 -5])

(defn convert-readings
  "Returns readings converted from celsius to fahrenheit."
  [readings]
  nil ; TODO: implement
  )

(defn classify-readings
  "Returns a classification string for each fahrenheit reading."
  [readings]
  nil ; TODO: implement
  )

(defn hot-days
  "Returns only the fahrenheit readings classified as hot."
  [readings]
  nil ; TODO: implement
  )

(defn average-temp
  "Returns the average of the fahrenheit readings."
  [readings]
  nil ; TODO: implement
  )

; Try it out once implemented:
(def fahrenheit-readings (convert-readings readings))
(println fahrenheit-readings)                                 ; expect (32.0 50.0 71.6 95.0 23.0)
(println (classify-readings fahrenheit-readings))              ; expect (cold cold mild hot freezing)
(println (hot-days fahrenheit-readings))                       ; expect (95.0)
(println (average-temp fahrenheit-readings))                   ; expect ~54.32 (floating-point, e.g. 54.32000000000001)
