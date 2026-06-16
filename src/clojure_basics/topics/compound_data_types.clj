(ns clojure-basics.topics.compound-data-types)

; Compound data types (collections) in Clojure: List, Vector, Map, Set
; All are immutable by default.

; --- List ---
; Ordered, allows duplicates, optimized for prepending
; in Clojure, () means a function call — '() quotes it to prevent evaluation
; alternatively, use (list ...) to create a list programmatically
(def my-empty-list '())

(def my-list-with-different-types '(1 "two" 'three 4))
(println my-list-with-different-types)

(def my-list-using-list-function (list "A" 'B 3))
(println my-list-using-list-function)

; --- Vector - arrays in other languages ---
; Ordered, allows duplicates, optimized for random access by index
(def my-empty-vector [])                                    ; [] is the literal syntax for an empty vector

(def my-age-vector [15 6 30 42])                            ; vectors preserve insertion order
(println my-age-vector)                                     ; prints [15 6 30 42]


; --- Map ---
; Key-value pairs, keys are unique
(def my-map {:key1 "value1" :key2 "value2"})
(println my-map)                                            ; prints {:key1 value1, :key2 value2}

; --- Set ---
; Unordered, no duplicates

(def empty-set #{})                                         ; #{} is the literal syntax for an empty set

(def set-with-different-types #{1 42 1.5 "Name" 'DOG})
(println set-with-different-types)                          ; prints the set (order is not guaranteed)

; sets do not allow duplicates. Using a literal #{} with duplicates throws a compile-time error
; to create a set from a collection that may have duplicates, use (set [...])
(def set-with-duplicates (set [1 1 2 3]))                   ; duplicates are removed
(println set-with-duplicates)                               ; prints #{1 3 2}