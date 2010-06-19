(ns chat)

; チャットデータの構造体
(defstruct message :sender :text)

; メッセージをつんでおくref
(def messages (ref ()))

; メッセージのポップ いけてない
(defn native-add-message [msg]
  (dosync (ref-set  messages (cons msg @messages))))

; メッセージのポップ いけてる
(defn add-message [msg]
  (dosync (alter messages conj msg)))

; メッセージのポップ commute版
(defn add-message-commute [msg]
  (dosync (commute messages conj msg)))
