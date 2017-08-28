(ns nhlxstats.services.player
  (:require [clojure.java.jdbc :as sql]
            [nhlxstats.config.db :refer [db]]))

(defn get-players []
  (sql/query db ["SELECT * FROM player"]))

(defn get-player [id]
  (first (sql/query db ["SELECT * FROM player WHERE id = ?" (bigint id)])))

(defn add-player [player]
    (first (sql/insert! db :player player)))