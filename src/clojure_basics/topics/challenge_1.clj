(ns clojure-basics.topics.challenge-1)

; Challenge: given a pet type and its age, calculate its age in human years.
; Uses a map to store the conversion ratio per pet type.

(def pet-types {:dog 7 :cat 5 :fish 10})

(defn calculate-pet-age-in-human-years
  "Returns the age of a pet converted to human years."
  [pet-type age]
  (let [pet-age-ratio (get pet-types pet-type)]
    (println (* age pet-age-ratio))))

(calculate-pet-age-in-human-years :fish 2)