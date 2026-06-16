(ns clojure-basics.topics.simple_data-types)

(defn integer-type
  "Demonstrates the integer data type. In Clojure, integers are 64-bit Longs by default."
  []
  (let [a 1]                                                ; let binds a local value
    (println a)                                             ; prints the value
    (println (type a))))                                    ; prints java.lang.Long


(defn float-type
  "Demonstrates the float data type. In Clojure, floats are java.lang.Double."
  []
  (let [a 1.75]
    (println a)                                             ; prints the value
    (println (type a))))                                    ; prints java.lang.Double


(defn float-type-scientific-notation
  "Demonstrates floats written in scientific notation. The type is still java.lang.Double."
  []
  (let [a 2.75e-12]
    (println a)                                             ; prints the value
    (println (type a))))                                    ; prints java.lang.Double


(defn hexadecimal-value-type
  "Demonstrates hexadecimal integer literals. Clojure reads them as java.lang.Long."
  []
  (let [a 0xfbfc]
    (println a)                                             ; prints the value (64508 in decimal)
    (println (type a))))                                    ; prints java.lang.Long


(defn nil-value-type
  "Demonstrates nil, the absence of a value. (type nil) returns nil, not a class."
  []
  (let [a nil]
    (println a)                                             ; prints nil
    (println (type a))))                                    ; prints nil


(defn boolean-value-type
  "Demonstrates the boolean data type. In Clojure, booleans are java.lang.Boolean."
  []
  (let [a true]
    (println a)                                             ; prints true
    (println (type a))))                                    ; prints java.lang.Boolean


(defn string-type
  "Demonstrates the string data type. In Clojure, strings are java.lang.String."
  []
  (let [a "String value"]
    (println a)                                             ; prints String value
    (println (type a))))                                    ; prints java.lang.String


(defn keyword-type
  "Demonstrates a keyword. Keywords are prefixed with : and commonly used as map keys."
  []
  (let [a :hello-world]
    (println a)                                             ; prints :hello-world
    (println (type a))))                                    ; prints clojure.lang.Keyword


(defn symbol-type
  "Demonstrates a symbol. Symbols are prefixed with ' and refer to identifiers in code."
  []
  (let [a 'hello-world]
    (println a)                                             ; prints hello-world
    (println (type a))))                                    ; prints clojure.lang.Symbol