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

