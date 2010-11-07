
(defun arith-prog (n)
  (cond
   ((zerop n) 0)
   (t (+ n (arith-prog (1- n ))))))

(arith-prog 4)

(defun geom-prog (n)
  (cond
   ((zerop n) 1)
   (t (+ (expt 2 n) (geom-prog (1- n))))))

(geom-prog 3)


(defun fibonacci (n)
  (cond
   ((= n 1) 1)
   ((= n 2) 1)
   (t (+ (fibonacci (- n 1))
	 (fibonacci (- n 2))))))

(fibonacci 12)


(defun sum (list)
  (cond
   ((null list) 0)
   (t (+ (car list) (sum (cdr list))))))


(sum '(1 2 3 4 5))


(defun repl (list old new)
  (cond
   ((null list) nil)
   (( eq (car list) old)
    (cons new (repl (cdr list) old new)))
   (t (cons (car list) (repl (cdr list) old new)))))

(repl '(hoge hoge hogehoge) 'hoge 'hage)


(defun del (x list)
  (cond
   ((null list) nil)
   ((eq (car list) x) (del x (cdr list)))
   (t (cons (car list) (del x (cdr list))))))

(del 'hoge '(hoge hoge hige) )


(defun memq (x set)
  (cond
   ((null set) nil)
   ((eq x (car set)) t)
   (t (memq set (cdr set)))))

(memq 'd '(a bs sfs fsaf))


(defun subset (set1 set2)
  (cond
   ((null set1) t)
   (t (and (memq (car set1) set2) (subset (cdr set1) set2)))))

(subset '(a) '(a b))


(defun assq (key list)
  (cond
   ((null list) nil)
   ((eq key (car (car list))) (car list))
   (t (assq key (cdr list)))))


(defun equiv (x y)
  (cond
   ((and (null x) (null y)) t)
   (( or (null x) (null y)) nil)
   (t (and (eq (car x) (car y))
	   (equiv (cdr x) (cdr y))))))

(equiv '(1 2) '(1 1 2))



