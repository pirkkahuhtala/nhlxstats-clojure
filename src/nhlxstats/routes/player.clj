(ns nhlxstats.routes.player
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [nhlxstats.services.player :refer [get-players add-player]]
            [nhlxstats.schemas.player :refer [Player]]))

(defroutes player-routes
  (context "/player" []
    (GET "/" []
      :summary "List of all players"
      :return [Player]
      (ok (get-players)))
    (POST "/" []
      :summary "Adds a new player"
      :body [player Player]
      :return Player
      (ok (add-player player)))))
