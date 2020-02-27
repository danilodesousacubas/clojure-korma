(ns clojure-rest-api.db
  (:use korma.db))

  (defdb db (mysql
            { :classname "com.mysql.jdbc.Driver"
              :subprotocol "mysql"
              :subname "//localhost/clojure"
              :user "root"
              :password ""}))