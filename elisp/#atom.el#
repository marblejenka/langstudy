
(defun sum* (list)
  (cond
   ((null list) 0)
   ((consp (car list)) (+ (sum* (car list)) (sum* (cdr list))))
   (t (+ (car list) (sum* (cdr list))))))

(sum* '(32 (23) (22 (22))))


(defun repl* (list old new)
  (cond
   ((null list) nil)
   ((consp (car list)) (cons (repl* (car list) old new) (repl* (cdr list) old new)))
   ((eq (car list) old) (cons new (repl* (cdr list) old new)))
   (t (cons (car list) (repl* (cdr list) old new)))))

(defun del* (x list)
  (cond
   ((null list) nil)
   ((consp (car list)) (cons (del* x (car list)) (del* x (cdr list))))
   ((eq (car list) x) (del* x (cdr list)))
   (t (cons (car list) (del* x (cdr list))))))

(del* 1 '(1 (1) (1 2) (1 (1 2))))




