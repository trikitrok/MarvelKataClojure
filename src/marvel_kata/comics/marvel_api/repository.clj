(ns marvel-kata.comics.marvel-api.repository
  (:require [clj-http.client :as client]
            [marvel-kata.comics.marvel-api.url :as api-url]
            [marvel-kata.comics.marvel-api.config :as api-config]
            [marvel-kata.comics.marvel-api.comics-mapping :as mapping]))

(declare get-as-json-map)

(defn all-comics-for-date [timestamp]
  (mapping/to-comics
    (get-as-json-map timestamp)))

(defn get-as-json-map [timestamp]
  (client/get 
    (api-url/generate 
      api-config/comics-api-url
      timestamp 
      api-config/public-key 
      api-config/private-key) 
    {:as :json}))