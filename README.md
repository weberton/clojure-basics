# Clojure Basics

Personal notes and exercises for learning Clojure from scratch. Each file covers one topic with commented examples that can be evaluated in the REPL.

## Topics

| # | Topic | File |
|---|-------|------|
| 1 | Functions | [functions.clj](src/clojure_basics/topics/functions.clj) |
| 2 | Data Types | [data_types.clj](src/clojure_basics/topics/data_types.clj) |
| 3 | Variables | [variables.clj](src/clojure_basics/topics/variables.clj) |
| 4 | Operators | [operators.clj](src/clojure_basics/topics/operators.clj) |
| 5 | Conditionals | [conditionals.clj](src/clojure_basics/topics/conditionals.clj) |
| 6 | Loops | [loops.clj](src/clojure_basics/topics/loops.clj) |

## Running

```bash
# Start an interactive REPL
lein repl

# Run the main entry point
lein run
```

Load any topic file in the REPL with:

```clojure
(load-file "src/clojure_basics/topics/functions.clj")
```

## Resources

- [Clojure.org — Getting Started](https://clojure.org/guides/getting_started)
- [Clojure for the Brave and True](https://www.braveclojure.com/)
- [ClojureDocs](https://clojuredocs.org)
- [Clojure Cheatsheet](https://clojure.org/api/cheatsheet)

## License

Copyright © 2026 Weberton Faria. Distributed under the Eclipse Public License 2.0.
