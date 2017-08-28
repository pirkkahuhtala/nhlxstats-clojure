(defproject nhlxstats "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring "1.6.2"]
                 [metosin/compojure-api "1.1.11"]
                 [org.clojure/java.jdbc "0.7.0"]
                 [org.postgresql/postgresql "42.1.4"]
                 [postgre-types "0.0.4"]
                 [cheshire "5.8.0"]
                 [ring-cors "0.1.11"]]

  :ring {:handler nhlxstats.core/app}
  :profiles {:dev
             {:dependencies [[proto-repl "0.3.1"]
                             [org.clojure/tools.nrepl "0.2.12"]]
              :plugins [[lein-ring "0.9.7"]]}})
