(ns counter)

; agentで値を持つ
;(def counter (agent 0))
(def counter (agent 0 :validator number?))

; 次の値をトランザクショナルに取得
;(defn next-counter [] (dosync (alter counter inc)))

; 次の値をトランザクショナルに取得するが、commuteは順序保証しないため、トランザクション内で参照する値とトランザクション終了後の値が必ずしも一致しない
;(defn next-counter-commute [] (dosync (commute counter inc)))

