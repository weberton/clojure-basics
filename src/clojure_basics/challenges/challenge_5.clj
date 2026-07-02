(ns clojure-basics.challenges.challenge-5)

; Challenge: simple inventory system
; Concepts: defrecord, atom, swap!, map, doseq, if, arithmetic operators
;
; Requirements:
; 1. Define a Product record with :name, :price and :stock fields
; 2. Create an atom inventory with a vector of initial products
; 3. Write add-stock to increase a product's stock by a given quantity
; 4. Write remove-stock to decrease stock if sufficient, otherwise print an error
; 5. Write total-inventory-value to return the total value (price * stock for each product)
; 6. Write print-inventory to print each product and the total inventory value

(defrecord Product [name price stock])

(def inventory (atom [(->Product "Book1" 15 3)
                      (->Product "TV" 199 10)
                      (->Product "Computer" 500 4)]))

(defn add-stock
  "Increases the stock of the product with the given name by quantity."
  [name quantity]
  (swap! inventory (fn [products]
                     (mapv (fn [product]
                             (if (= (:name product) name)
                               (assoc product :stock (+ (:stock product) quantity))
                               product))
                           products))))

(defn total-inventory-value
  "Returns the total value of all products (price * stock summed)."
  []
  (let [total (atom 0)]
    (doseq [product @inventory]
      (swap! total + (* (:price product) (:stock product))))
    @total))

(defn remove-stock
  "Decreases the stock of the product with the given name by quantity if sufficient, otherwise prints an error."
  [name quantity]
  (swap! inventory (fn [products]
                     (mapv (fn [product]
                             (if (= (:name product) name)
                               (if (>= (:stock product) quantity)
                                 (assoc product :stock (- (:stock product) quantity))
                                 (do (println "Insufficient stock for" name) product))
                               product))
                           products))))

(defn print-inventory
  "Prints each product's name, price and stock, followed by the total inventory value."
  []
  (doseq [product @inventory]
    (println (:name product) "| Price:" (:price product) "| Stock:" (:stock product)))
  (println "Total inventory:" (total-inventory-value)))

(print-inventory)
(add-stock "Book1" 5)
(print-inventory)
(remove-stock "Book1" 5)
(print-inventory)
(remove-stock "Book1" 5)