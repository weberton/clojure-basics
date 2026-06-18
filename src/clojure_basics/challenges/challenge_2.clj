(ns clojure-basics.challenges.challenge-2)

; Challenge: simple bank account using an atom to manage mutable balance.
; Concepts: atom, swap!, @, if, do, defn, arithmetic operators
;
; Requirements:
; 1. Create an atom to store the initial balance
; 2. Write a deposit function that adds an amount and prints the new balance
; 3. Write a withdraw function that subtracts if funds are sufficient, otherwise prints an error
; 4. Write a print-balance function that prints the current balance

(def balance (atom 100))

(defn deposit
  "Adds amount to the balance and prints the new balance."
  [amount]
  (swap! balance + amount)
  (println @balance))

(defn withdraw
  "Subtracts amount from the balance if funds are sufficient, otherwise prints an error."
  [amount]
  (if (>= @balance amount)
    (do
      (swap! balance - amount)
      (println @balance))
    (println "Insufficient funds")))

(defn print-balance
  "Prints the current balance."
  []
  (println @balance))

(deposit 50)
(print-balance)                                             ; balance 150
(withdraw 100)
(print-balance)                                             ;balance 50
(withdraw 60)                                               ;Insufficient funds