(ns nhlxstats.services.player
  (:require [clojure.java.jdbc :as sql]
            [nhlxstats.config.db :refer [db]]))

(defn get-players []
  (sql/query db ["SELECT * FROM player"]))

(defn add-player [player]
  (first (sql/insert! db :player player)))
