(ns clojure-rest-api.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clojure-rest-api.store :as store]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]))

(defroutes all-routes
  (GET "/stores" [] 
    (store/find-all))
  (GET "/stores/:id" [id] 
    (store/find-by-id id))
  (POST "/stores" req
    (let [name (get-in req [:body "name"])
          email (get-in req [:body "email"])
          codigo (get-in req [:body "codigo"])]
          (store/create name email codigo)))
  (DELETE "/stores/:id" [id]
    (store/delete-by-id id)
    (str "deleted store id " id))
  (PUT "/stores/:id" req
    (let [id (read-string (get-in req [:params :id]))
          name (get-in req [:body "name"])
          email (get-in req [:body "email"])
          codigo (get-in req [:body "codigo"])]
          (store/update-by-id id name email codigo)
          (store/find-by-id id)))
  (route/not-found "Not Found"))

(def app
  (-> all-routes
      wrap-json-response
      wrap-json-body))
