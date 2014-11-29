(ns marvel-kata.core
  (:require [clj-http.client :as client]))

(def ts 987)
(def public-key "97f295907072a970c5df30d73d1f3816")
(def private-key "ed54a875c0dffad1fa6af84e66ff104434a1c6cc")
(def comics-api-url "http://gateway.marvel.com:80/v1/public/comics")
(def date-descriptor-parameter "dateDescriptor=nextWeek")

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

(defn ts-parameter [ts]
  (str "ts=" ts))

(defn api-key-parameter [public-key]
  (str "apikey=" public-key))

(defn md5
  "Generate a md5 checksum for the given string"
  [token]
  (let [hash-bytes
        (doto (java.security.MessageDigest/getInstance "MD5")
          (.reset)
          (.update (.getBytes token)))]
    (.toString
      (new java.math.BigInteger 1 (.digest hash-bytes))
      16)))

(defn create-hash [ts public-key private-key]
  (md5 (str ts private-key public-key)))

(defn hash-parameter [ts public-key private-key]
  (str "hash=" (create-hash ts public-key private-key)))

(defn gen-api-call-parameters [ts public-key private-key]
  (clojure.string/join
    "&"
    [date-descriptor-parameter
     (ts-parameter ts)
     (api-key-parameter public-key)
     (hash-parameter ts public-key private-key)]))

(defn gen-api-call-url [ts public-key private-key]
  (clojure.string/join
    "?"
    [comics-api-url
     (gen-api-call-parameters ts public-key private-key)]))

(defn get-comics []
  (create-comics 
    (extract-comics-data
      (get-comics-data-as-json-map
        (gen-api-call-url ts public-key private-key)))))