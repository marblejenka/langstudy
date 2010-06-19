(ns counter)

; refで値を持つ
(def counter (ref 0))

; 次の値をトランザクショナルに取得
(defn next-counter [] (dosync (alter counter inc)))

; 次の値をトランザクショナルに取得するが、commuteは順序保証しないため、トランザクション内で参照する値とトランザクション終了後の値が必ずしも一致しない
(defn next-counter-commute [] (dosync (commute counter inc)))

