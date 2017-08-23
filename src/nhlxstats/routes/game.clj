(ns nhlxstats.routes.game
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [nhlxstats.schemas.game :refer [Game]]
            [nhlxstats.services.game :refer [get-games get-game add-game]]))

(defroutes game-routes
  (context "/game" []
    (GET "/" []
      :summary "List of games"
      :return [Game]
      (ok (get-games)))
    (GET "/:id" [id]
      :return Game
      :summary "Single game by id"
      (let [game (get-game id)]
        (if game (ok game) (not-found))))
    (POST "/" []
      :body [game Game]
      :return Game
      :summary "Creates a new game"
      (ok (add-game game)))))
