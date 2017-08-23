(ns nhlxstats.core
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [schema.core :as s]
            [ring.swagger.schema :as rs]
            [nhlxstats.routes.game :refer [game-routes]]
            [nhlxstats.routes.player :refer [player-routes]]
            [postgre-types.json :refer [add-jsonb-type]]
            [cheshire.core :refer :all]))

; For jsonb db types
; (add-jsonb-type generate-string (fn [x] (parse-string x true)))

(def app
  (api
    {:swagger
     {:ui   "/"
      :spec "/swagger.json"
      :data {:info {:title "nhlXstats"}
             :tags [{:name "api"}]}}}
    (context "/api" []
             :tags ["api"]
      game-routes
      player-routes)))
