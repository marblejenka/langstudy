(ns chat)

; �`���b�g�f�[�^�̍\����
(defstruct message :sender :text)

; ���b�Z�[�W����ł���ref
(def messages (ref ()))

; ���b�Z�[�W�̃|�b�v �����ĂȂ�
(defn native-add-message [msg]
  (dosync (ref-set  messages (cons msg @messages))))

; ���b�Z�[�W�̃|�b�v �����Ă�
(defn add-message [msg]
  (dosync (alter messages conj msg)))

; ���b�Z�[�W�̃|�b�v commute��
(defn add-message-commute [msg]
  (dosync (commute messages conj msg)))
