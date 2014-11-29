(ns marvel-kata.core
  (:require [clj-http.client :as client])
  (:require [marvel-kata.comics.api-url.generator :as generator])
  (:require [marvel-kata.comics.api-url.config :as api-url-config]))
  
            ; [marvel-kata.api-url.generator :as generator]
            ; [marvel-kata.api-url.config :as api-url-config]))

(defn get-comics-data-as-json-map [url]
  (client/get url {:as :json}))

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
      (get-comics-data-as-json-map
        (generator/gen-api-call-url 
          api-url-config/comics-api-url
          api-url-config/ts 
          api-url-config/public-key 
          api-url-config/private-key)))))