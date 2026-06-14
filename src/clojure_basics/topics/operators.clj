(ns clojure-basics.topics.operators)

; Operators are symbols that tell the system to perform mathematical or logical manipulation.
; In Clojure, operators are functions: (+ 1 2), (= 1 1), (and true false).
; There are arithmetic, relational, logical, and bitwise operators.

; -------Arithmetic operators ----

(defn sum-two-numbers
  "Sums two operands."
  [x y]
  (+ x y))                                                  ; returns x + y

(defn subtract-two-numbers
  "Subtracts two operands."
  [x y]
  (- x y))                                                  ; returns x - y

(defn multiply-two-numbers
  "Multiplies two operands."
  [x y]
  (* x y))                                                  ; returns x * y

(defn divide
  "Divides two operands."
  [x y]
  (/ x y))                                                  ; returns x / y

(defn increment-number
  "Increments a number by 1."
  [x]
  (inc x))                                                  ; returns x + 1

(defn decrement-number
  "Decrements a number by 1."
  [x]
  (dec x))                                                  ; returns x - 1

(defn max-of-numbers
  "Returns the largest of two numbers."
  [x y]
  (max x y))

(defn min-of-numbers
  "Returns the minimum of two numbers."
  [x y]
  (min x y))

(defn remainder
  "Returns the remainder of dividing x by y."
  [x y]
  (rem x y))


; -------Relational operators ----

(defn equal-to?
  "Returns true if x and y are equal."
  [x y]
  (= x y))

(defn not-equal-to?
  "Returns true if x and y are NOT equal."
  [x y]
  (not= x y))

(defn less-than?
  "Returns true if x is strictly less than y."
  [x y]
  (< x y))

(defn less-than-or-equal?
  "Returns true if x is less than or equal to y."
  [x y]
  (<= x y))

(defn greater-than?
  "Returns true if x is strictly greater than y."
  [x y]
  (> x y))

(defn greater-than-or-equal?
  "Returns true if x is greater than or equal to y."
  [x y]
  (>= x y))

; -------Logical operators ----

; -- and --
(def has-license? true)
(def is-adult?    true)

; and: returns true only if ALL conditions are truthy
(println (and has-license? is-adult?))   ; true  — both are true
(println (and has-license? false))       ; false — one is false
(println (and nil is-adult?))            ; nil   — first falsy value wins

; -- or --
(def is-admin?  false)
(def is-editor? true)

; or: returns true if AT LEAST ONE condition is truthy
(println (or is-admin? is-editor?))      ; true  — one is true
(println (or false false))               ; false — none are true
(println (or nil is-editor?))            ; true  — returns first truthy value

; -- not --
; not: inverts a boolean value — always returns true or false
(println (not true))                     ; false
(println (not false))                    ; true
(println (not nil))                      ; true  — nil is falsy, so not returns true
