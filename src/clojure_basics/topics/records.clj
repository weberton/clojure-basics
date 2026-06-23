(ns clojure-basics.topics.records)

; defrecord — defines a named record type with fixed fields
; the modern alternative to the deprecated defstruct
; fields are accessed like map keys using keywords

(defrecord Pet [pet-type pet-name])                         ; defines a Pet record with two fields

(defn print-pet
  "Creates a Pet record and prints it and its individual fields."
  []
  (let [my-pet (->Pet "dog" "Rex")]                         ; ->Pet is the constructor
    (println my-pet)                                        ; prints the full record
    (println (:pet-type my-pet))                            ; prints dog
    (println (:pet-name my-pet))))                          ; prints Rex

(print-pet)


; map->Pet — alternative constructor, creates a record from a map
; assoc — returns a new record with a field updated, original is unchanged (immutable)
(defn update-pet-name
  "Demonstrates map->Pet constructor and updating a field with assoc."
  []
  (let [my-pet     (map->Pet {:pet-type "cat" :pet-name "Whiskers"}) ; create from map
        pet-renamed (assoc my-pet :pet-name "Luna")]                  ; returns a new record
    (println my-pet)                                        ; prints #user.Pet{:pet-type cat, :pet-name Whiskers}
    (println pet-renamed)))                                 ; prints #user.Pet{:pet-type cat, :pet-name Luna}

(update-pet-name)
