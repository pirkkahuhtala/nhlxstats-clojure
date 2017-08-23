(ns nhlxstats.services.game
  (:require [clojure.java.jdbc :as sql]
            [nhlxstats.config.db :refer [db]]))

(defn get-games []
  (sql/query db ["select * from game"]))

(defn get-game [id]
  (first (sql/query db ["select * from game where id=?" (bigint id)])))

(defn add-game [game]
  (first (sql/insert! db :game game)))
