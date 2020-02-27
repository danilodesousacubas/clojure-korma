(ns clojure-rest-api.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clojure-rest-api.store :as store]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]))

(defroutes all-routes
  (GET "/hello" [] "Hi")
  (GET "/stores" [] 
    (store/find-all))
  (route/not-found "Not Found"))

(def app
  (-> all-routes
      wrap-json-response
      wrap-json-body))
