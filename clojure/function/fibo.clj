(defn tail-fibo [n]
  (letfn [(fib [current next n] (if (zero? n) current (fib next (+ current next) (dec n))))]
    (fib 0 1 n)))

