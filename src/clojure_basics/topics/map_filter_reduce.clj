(ns clojure-basics.topics.map-filter-reduce)

; map, filter and reduce are the three core functions for working with collections.
; None of them mutate the original collection — they all return something new.

; ---------------------------------------------------------------------------
; map — transforms every element, returns a new collection of the same length
; (map f collection) applies f to each element and collects the results
; ---------------------------------------------------------------------------

(def numbers [1 2 3 4 5])

(defn double-it
  [x]
  (* x 2))

(println (map double-it numbers))                            ; prints (2 4 6 8 10)

; map also works with an anonymous function — handy for one-off logic
(println (map (fn [x] (* x x)) numbers))                     ; prints (1 4 9 16 25)

; #(...) is shorthand for a small anonymous function, % is its argument
(println (map #(* % %) numbers))                              ; prints (1 4 9 16 25) — same as above

; map can walk two collections in parallel, passing one element from each to f
(def prices [10 20 30])
(def quantities [2 3 1])

(println (map * prices quantities))                          ; prints (20 60 30) — price * quantity per item


; ---------------------------------------------------------------------------
; filter — keeps only the elements that satisfy a predicate (a fn returning true/false)
; (filter pred collection) — same length or shorter, never transforms values
; ---------------------------------------------------------------------------

(defn even-number?
  [x]
  (= (rem x 2) 0))

(println (filter even-number? numbers))                       ; prints (2 4)

(println (filter #(> % 2) numbers))                            ; prints (3 4 5)

; remove is the opposite of filter — keeps elements where the predicate is false
(println (remove even-number? numbers))                       ; prints (1 3 5)


; ---------------------------------------------------------------------------
; reduce — collapses a collection into a single value by repeatedly applying f
; (reduce f collection) — f takes (accumulator, element) and returns the new accumulator
; ---------------------------------------------------------------------------

(println (reduce + numbers))                                  ; prints 15 — 1+2+3+4+5

; reduce with an explicit starting value: (reduce f start collection)
(println (reduce + 100 numbers))                              ; prints 115 — starts accumulator at 100

; reduce with a custom function — building up the largest value seen so far
(defn keep-larger
  [acc x]
  (if (> x acc) x acc))

(println (reduce keep-larger numbers))                        ; prints 5 — same as (apply max numbers)

; reduce can build any kind of result, not just numbers — here, a string
(println (reduce str numbers))                                ; prints "12345"


; ---------------------------------------------------------------------------
; combining them — a typical pipeline: filter, then map, then reduce
; read it inside-out, or top-down as: keep evens -> square them -> sum them
; ---------------------------------------------------------------------------

(defn sum-of-squares-of-evens
  [coll]
  (reduce + (map #(* % %) (filter even-number? coll))))

(println (sum-of-squares-of-evens [1 2 3 4 5 6]))              ; prints 56 — 2^2 + 4^2 + 6^2