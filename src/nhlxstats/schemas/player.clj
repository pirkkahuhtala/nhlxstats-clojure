(ns nhlxstats.schemas.player
  (:require [schema.core :as s]))

(s/defschema Player
  "A schema for player profile"
  {(s/optional-key :id) s/Int
   :name s/Str})
