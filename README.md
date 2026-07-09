# Clojure Basics

Personal notes and exercises for learning Clojure from scratch. Each file covers one topic with commented examples that can be evaluated in the REPL.

## Topics

| # | Topic | File |
|---|-------|------|
| 1 | Functions | [functions.clj](src/clojure_basics/topics/functions.clj) |
| 2 | Simple Data Types | [simple_data_types.clj](src/clojure_basics/topics/simple_data_types.clj) |
| 3 | Compound Data Types | [compound_data_types.clj](src/clojure_basics/topics/compound_data_types.clj) |
| 4 | Variables | [variables.clj](src/clojure_basics/topics/variables.clj) |
| 5 | Operators | [operators.clj](src/clojure_basics/topics/operators.clj) |
| 6 | Conditionals | [conditionals.clj](src/clojure_basics/topics/conditionals.clj) |
| 7 | Loops | [loops.clj](src/clojure_basics/topics/loops.clj) |
| 8 | Atoms | [atoms.clj](src/clojure_basics/topics/atoms.clj) |
| 9 | Sequences | [sequences.clj](src/clojure_basics/topics/sequences.clj) |
| 10 | Records | [records.clj](src/clojure_basics/topics/records.clj) |
| 11 | Map, Filter, Reduce | [map_filter_reduce.clj](src/clojure_basics/topics/map_filter_reduce.clj) |

## Challenges

| # | Challenge | File |
|---|-----------|------|
| 1 | Pet age calculator | [challenge_1.clj](src/clojure_basics/challenges/challenge_1.clj) |
| 2 | Simple bank account | [challenge_2.clj](src/clojure_basics/challenges/challenge_2.clj) |
| 3 | Student report card | [challenge_3.clj](src/clojure_basics/challenges/challenge_3.clj) |
| 4 | To-do list using atoms and records | [challenge_4.clj](src/clojure_basics/challenges/challenge_4.clj) |
| 5 | Simple inventory system | [challenge_5.clj](src/clojure_basics/challenges/challenge_5.clj) |
| 6 | Movie ticket pricing | [challenge_6.clj](src/clojure_basics/challenges/challenge_6.clj) |
| 7 | Shopping cart totals | [challenge_7.clj](src/clojure_basics/challenges/challenge_7.clj) |
| 8 | Employee bonus calculator | [challenge_8.clj](src/clojure_basics/challenges/challenge_8.clj) |

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
