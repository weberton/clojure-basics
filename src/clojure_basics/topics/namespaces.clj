(ns clojure-basics.topics.namespaces
  (:require [clojure-basics.topics.namespace-helpers :as helpers]
            [clojure.string :as str]))

; A namespace is just a named container of vars (defs, defns, records...).
; Every file in this project starts with (ns some.dotted.path) — that line
; both names the namespace and must match the file's path/name
; (clojure-basics.topics.namespaces -> topics/namespaces.clj, underscores for dashes).

; ---------------------------------------------------------------------------
; :require + :as — pull in another namespace and give it a short alias.
; Once required, call its public functions as alias/fn-name.
; ---------------------------------------------------------------------------

(println (helpers/greet "World"))                            ; prints "Hello, World!"
(println (helpers/square 6))                                 ; prints 36

; The same trick works for Clojure's own library namespaces, not just yours —
; clojure.string is aliased as str above.
(println (str/upper-case "shout this"))                       ; prints "SHOUT THIS"
(println (str/join ", " ["a" "b" "c"]))                       ; prints "a, b, c"


; ---------------------------------------------------------------------------
; Fully-qualified calls — no alias needed if you don't mind typing the whole path
; ---------------------------------------------------------------------------

(println (clojure-basics.topics.namespace-helpers/greet "Fully Qualified"))  ; prints "Hello, Fully Qualified!"


; ---------------------------------------------------------------------------
; :refer — pull specific names in directly, so you can call them unqualified.
; Handy for a couple of names; risky for many (name collisions, unclear origin).
; This is a separate require call here (rather than in the ns form above) just
; to keep it visually distinct from the :as require — in real code it would
; normally live in the ns form's :require too.
; ---------------------------------------------------------------------------

(require '[clojure-basics.topics.namespace-helpers :refer [square]])

(println (square 9))                                          ; prints 81 — no alias needed now


; ---------------------------------------------------------------------------
; defn- — private functions, only callable from inside their own namespace
; ---------------------------------------------------------------------------

(println (helpers/reveal-secret))                              ; prints the secret message via a public wrapper

; Uncommenting the line below would fail to compile:
; Syntax error compiling at (...) - Unable to resolve symbol: helpers/secret-message
; (helpers/secret-message)


; ---------------------------------------------------------------------------
; Why bother? Splitting code into namespaces keeps files small and lets you
; reuse functions (like challenge_8's bonus-rate) without copy-pasting them
; into every file that needs them — see challenge_10 for a hands-on version.
; ---------------------------------------------------------------------------
