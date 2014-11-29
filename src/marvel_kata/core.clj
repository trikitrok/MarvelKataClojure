(ns marvel-kata.core
  (:require [marvel-kata.comics.marvel-api.raw-comic-data :as raw-comic-data]))

(defn path [thumbnail]
  (str (:path thumbnail) "." (:extension thumbnail)))

(defn price [prices]
  (:price (first prices)))

(defn create-comic [thumbnail title price]
  {:thumbnail thumbnail :title title :price price})

(def create-comics
  (partial map
           #(create-comic (path (:thumbnail %))
                          (:title %)
                          (price (:prices %)))))

(defn extract-comics-data [mapped-data]
  (get-in mapped-data [:body :data :results]))

(defn get-comics []
  (create-comics 
    (extract-comics-data
      (raw-comic-data/get-as-json-map))))