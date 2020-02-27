(ns clojure-rest-api.store
  (:require [korma.db :refer :all]
            [korma.core :refer :all]
            [clojure-rest-api.db :refer :all]))

(defentity store)

(defn find-all []
  (select store))

(defn find-by-id [id]
  (select store
    (where {:id id})
    (limit 1)))

(defn create [name email codigo]
  (insert store
    (values {:name name :email email :codigo codigo})))

(defn delete-by-id [id]
  (delete store
    (where {:id id})))

(defn update-by-id [id name email codigo]
  (update store 
    (set-fields {:name name :email email :codigo codigo})
      (where {:id id})))