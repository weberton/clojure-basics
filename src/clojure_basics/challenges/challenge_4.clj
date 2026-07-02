(ns clojure-basics.challenges.challenge-4)

(defrecord Task [name done])

(def tasks (atom []))

(defn add-task
  [title]
  (let [task (->Task title false)]
    (swap! tasks conj task)))

(defn complete-task
  [title]
  (swap! tasks (fn [current-tasks]
                 (map (fn [task]
                        (if (= (:name task) title)
                          (assoc task :done true)
                          task))
                      current-tasks))))

(defn print-tasks
  []
  (doseq [task @tasks]
    (let [status (if (:done task) "[x]" "[ ]")]
      (println status (:name task)))))

(add-task "Buy Groceries")
(add-task "Read a book")
(complete-task "Buy Groceries")

(print-tasks)