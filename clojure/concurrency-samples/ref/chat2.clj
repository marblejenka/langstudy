(ns ref.chat2)

; �`���b�g�f�[�^�̍\����
(defstruct message :sender :text)

; ��ѐ��`�F�b�N
(def validate-message-list
  (partial every? #(and (:sender %) (:text %))))

; ���b�Z�[�W����ł���ref
(def messages (ref () :validator validate-message-list))

; ���b�Z�[�W�̃|�b�v �����ĂȂ�
(defn native-add-message [msg]
  (dosync (ref-set messages (cons msg @messages))))

; ���b�Z�[�W�̃|�b�v �����Ă�
(defn add-message [msg]
  (dosync (alter messages conj msg)))

; ���b�Z�[�W�̃|�b�v commute��
(defn add-message-commute [msg]
  (dosync (commute messages conj msg)))

