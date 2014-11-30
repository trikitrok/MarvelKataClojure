(ns marvel-kata.comics.marvel-api.raw-comic-data
  (:require [clj-http.client :as client]
            [marvel-kata.comics.marvel-api.url :as api-url]
            [marvel-kata.comics.marvel-api.config :as api-config]))

(defn get-as-json-map [timestamp]
  (client/get 
    (api-url/generate 
      api-config/comics-api-url
      timestamp 
      api-config/public-key 
      api-config/private-key) 
    {:as :json}))