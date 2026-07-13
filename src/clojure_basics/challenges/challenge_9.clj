(ns clojure-basics.challenges.challenge-9)

; Challenge: library book tracker
; Concepts: defrecord, atom, cond, map, filter, reduce
; A cumulative review — no new functions, just combining atoms and records
; (challenge 4) with the cond/map/filter/reduce trio (challenge 8) in a new scenario.
;
; Requirements:
; 1. Define a record `Book` with fields :title, :author, :available
; 2. Define an atom `library` holding a vector of at least 5 Books, all :available true
; 3. Write borrow-book using swap! + map + cond:
;    - takes a title
;    - updates the book matching that title to :available false
;    - if the title doesn't match, or the book is already unavailable, leave it unchanged
;    - (hint: map over the books; inside the mapping fn, use cond to decide
;       whether to return an updated book via assoc, or the book as-is)
; 4. Write available-books using filter:
;    - returns only the books in library that are currently :available
; 5. Write books-by-author using filter:
;    - takes an author name
;    - returns only the books in library written by that author
; 6. Write borrowed-count using reduce (or filter + count):
;    - returns how many books in library are currently unavailable
; 7. Call each function below and check the printed results against the comments

(defrecord Book [title author available])

(def library (atom [(->Book "Clojure for the Brave and True" "Daniel Higginbotham" true)
                    (->Book "SICP" "Abelson & Sussman" true)
                    (->Book "The Pragmatic Programmer" "Hunt & Thomas" true)
                    (->Book "Clean Code" "Robert Martin" true)
                    (->Book "Refactoring" "Martin Fowler" true)]))

(defn borrow-book
  "Marks the book with the given title as unavailable, if it's currently available."
  [title]
  (swap! library (fn [books]
                   (map (fn [current-book]
                          (if (= title (:title current-book))
                            (assoc current-book :available false)
                            current-book))
                        books)))
  )

(defn available-books
  "Returns only the books that are currently available."
  []
  (filter (fn [book]
            (= (:available book) true))
          @library)
  )

(defn books-by-author
  "Returns only the books written by the given author."
  [author]
  (filter (fn [book]
            (= (:author book) author))
          @library)
  )

(defn borrowed-count
  "Returns how many books are currently unavailable."
  []
  (count (filter (fn [book]
                   (= (:available book) false))
                 @library))
  )

; Try it out once implemented:
(borrow-book "Clean Code")
(borrow-book "SICP")
(println (available-books))                                 ; expect 3 books: Brave and True, Pragmatic Programmer, Refactoring
(println (books-by-author "Martin Fowler"))                 ; expect Refactoring
(println (borrowed-count))                                  ; expect 2