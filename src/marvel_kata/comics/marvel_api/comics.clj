(ns marvel-kata.comics.marvel-api.comics
  (:require [marvel-kata.comics.marvel-api.raw-comic-data :as raw-comic-data]
            [marvel-kata.comics.marvel-api.comics-mapping :as mapping]))

(defn get-all []
  (mapping/to-comics
      (raw-comic-data/get-as-json-map)))