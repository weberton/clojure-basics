(ns clojure-basics.topics.namespace-helpers)

; A small support namespace for topics/namespaces.clj to require.
; Nothing to run here directly — this file only exists to be required by another.

(defn greet
  [name]
  (str "Hello, " name "!"))

(defn square
  [x]
  (* x x))

; defn- makes a function private — it can only be called from inside this
; namespace. Code that requires this namespace cannot see or call it.
(defn- secret-message
  []
  "You can only read this from inside namespace-helpers.")

(defn reveal-secret
  "Public wrapper that calls the private fn on this namespace's behalf."
  []
  (secret-message))