;; This buffer is for notes you don't want to save, and for Lisp evaluation.
;; If you want to create a file, visit that file with C-x C-f,
;; then enter the text in that file's own buffer.


(defun factorial (n)
  (cond
   ((zerop n) 1)
   (t (* n (factorial (1- n))))))

;; (factorial 5)



