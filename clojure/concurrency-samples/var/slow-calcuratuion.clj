(ns var.slow-calcuratuion)

(defn slow-double [n]
  (Thread/sleep 100)
  (* n 2))

(defn call-slow-double []
  (map slow-double [1 3 3 32 23 3 23 2 2 2]))

(defn run (time (dorun (call-slow-double))))

(defn call-memorized-slow-double []
  (time
    (dorun
      (binding [slow-double (memoize slow-double)]
        (call-slow-double)))))
