(ns clojure-basics.topics.sequences)

; sequences — a logical view over a collection (vector, list, map, set, string)
; Clojure's collection functions (map, filter, reduce) all work on sequences

(def colors (seq ["red" "blue"]))
(println colors)                                            ; prints (red blue)

; cons — adds an element to the front of a sequence, returns a new sequence
; sequences are immutable — the original is never modified
(defn prepend-color
  "Adds a new color to the front of the colors sequence and prints both the new and original."
  [new-color]
  (println (cons new-color colors))                         ; prints (black red blue)
  (println colors))                                         ; prints (red blue) — original unchanged

(prepend-color "black")



; wrong usage — cons expects (cons element sequence), not (cons sequence element)
; passing a string as the second argument treats it as a sequence of characters
(defn cons-wrong-order
  "Demonstrates what happens when cons arguments are in the wrong order."
  [new-color]
  (println (cons colors new-color))                         ; prints (("red" "blue") \o \r \a \n \g \e)
  (println colors))                                         ; prints (red blue) — original unchanged

(cons-wrong-order "orange")

; conj — adds an element to a collection, position depends on the collection type
; on a vector: adds to the end  → (conj ["red" "blue"] "white") => ["red" "blue" "white"]
; on a list/seq: adds to the front → (conj '("red" "blue") "white") => ("white" "red" "blue")
(defn conj-example
  "Demonstrates conj on a seq — adds to the front since seq is list-like."
  [new-color]
  (println (conj colors new-color))                         ; prints (white red blue) — added to front
  (println colors))                                         ; prints (red blue) — original unchanged

(conj-example "white")


; concat — joins two or more sequences into a new sequence, always appends to the end
(defn concat-example
  "Concatenates colors with a new list of colors and prints the result."
  [new-colors]
  (println (concat colors new-colors)))                     ; prints (red blue white black)

(concat-example ["white" "black"])