(ns clojure-basics.challenges.challenge-3)

; Challenge: student report card
; Concepts: defrecord, vector, cond, defn, doseq, let, keywords
;
; Requirements:
; 1. Define a Student record with :name and :score fields
; 2. Create a vector of at least 4 students
; 3. Write a get-grades function that returns a grade based on the score
; 4. Write a print-student-report function that prints name, score and grade
; 5. Use doseq to print the report for all students

(defrecord Student [name score])

(def students [(->Student "Dan" 97)
               (->Student "Mary" 77)
               (->Student "John" 55)
               (->Student "Logan" 70)])

(defn get-grades
  "Returns a letter grade based on the score."
  [score]
  (cond
    (>= score 90) "A"
    (>= score 75) "B"
    (>= score 60) "C"
    :else "F"))

(defn print-student-report
  "Prints the name, score and grade for a given student."
  [student]
  (println "Name:" (:name student) "| Score:" (:score student) "| Grade:" (get-grades (:score student))))

(defn print-all
  "Prints the report card for all students."
  []
  (doseq [student students]
    (print-student-report student)))

(print-all)