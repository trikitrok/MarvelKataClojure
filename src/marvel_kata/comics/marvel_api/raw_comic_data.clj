(ns marvel-kata.comics.marvel-api.raw-comic-data
  (:require [clj-http.client :as client]
            [marvel-kata.comics.marvel-api.url.generator :as generator]
            [marvel-kata.comics.marvel-api.url.config :as api-url-config]))

(defn get-as-json-map []
  (client/get 
    (generator/gen-api-call-url 
      api-url-config/comics-api-url
      api-url-config/ts 
      api-url-config/public-key 
      api-url-config/private-key) 
    {:as :json}))