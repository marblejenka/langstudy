(ns counter)

; ref�Œl������
(def counter (ref 0))

; ���̒l���g�����U�N�V���i���Ɏ擾
(defn next-counter [] (dosync (alter counter inc)))

; ���̒l���g�����U�N�V���i���Ɏ擾���邪�Acommute�͏����ۏ؂��Ȃ����߁A�g�����U�N�V�������ŎQ�Ƃ���l�ƃg�����U�N�V�����I����̒l���K��������v���Ȃ�
(defn next-counter-commute [] (dosync (commute counter inc)))

