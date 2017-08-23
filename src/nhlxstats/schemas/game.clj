(ns nhlxstats.schemas.game
  (:require [schema.core :as s]))

(s/defschema Game
  "A schema for game"
  {:id s/Int
   (s/optional-key :name) s/Str
   :date s/Str ; TODO: should be date in the future
   :homePlayerId s/Int
   :visitorPlayerId s/Int
   :homeGoals s/Int
   :visitorGoals s/Int})
