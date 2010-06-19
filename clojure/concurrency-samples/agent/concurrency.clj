(ns agent.concurrency)

(use `[clojure.contrib.duck-streams :only (spit)])

; チャットデータの構造体
(defstruct message :sender :text)

; 一貫性チェック
(def validate-message-list
  (partial every? #(and (:sender %) (:text %))))

; メッセージをつんでおくref
(def messages (ref () :validator validate-message-list))

; メッセージのポップ いけてない
(defn native-add-message [msg]
  (dosync (ref-set messages (cons msg @messages))))

; メッセージのポップ いけてる
(defn add-message [msg]
  (dosync (alter messages conj msg)))

; メッセージのポップ commute版
(defn add-message-commute [msg]
  (dosync (commute messages conj msg)))

; メッセージをファイルに書き出す
(def backup-agent (agent "output/mesages-backup.clj"))

; バックアップを取りながらメッセージを追加
(defn add-message-with-backup [msg]
  (dosync
    (let [snapshot (commute messages conj msg)]
      (send-off backup-agent (fn [filename]
                               (spit filename snapshot)
                               filename))
      snapshot)))

