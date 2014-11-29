(ns marvel-kata.core
  (:require [marvel-kata.comics.marvel-api.comics :as comics]))

(defn get-comics []
  (comics/get-all))