(ns marvel-kata.comics.marvel-api.repository
  (:require [marvel-kata.comics.marvel-api.raw-comic-data :as raw-comic-data]
            [marvel-kata.comics.marvel-api.comics-mapping :as mapping]))

(defn all-comics-for-date [timestamp]
  (mapping/to-comics
      (raw-comic-data/get-as-json-map timestamp)))