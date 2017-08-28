(ns nhlxstats.routes.player
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [nhlxstats.services.player :refer [get-player get-players add-player]]
            [nhlxstats.schemas.player :refer [Player]]))

(defroutes player-routes
  (context "/player" []
    (GET "/" []
      :summary "List of all players"
      :return [Player]
      (ok (get-players)))
    (GET "/:id" [id]
      :return Player
      :summary "List of all players"
      (let [player (get-player id)]
        (if player (ok player) (not-found))))
    (POST "/" []
      :summary "Adds a new player"
      :body [player Player]
      :return Player
      (ok (add-player player)))))

