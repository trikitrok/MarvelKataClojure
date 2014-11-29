(ns marvel-kata.api-url.generator)

(declare 
  date-descriptor-parameter
  ts-parameter
  api-key-parameter
  md5
  create-hash
  hash-parameter
  gen-api-call-parameters)

(defn gen-api-call-url [comics-api-url ts public-key private-key]
  (clojure.string/join
    "?"
    [comics-api-url
     (gen-api-call-parameters ts public-key private-key)]))

(defn gen-api-call-parameters [ts public-key private-key]
  (clojure.string/join
    "&"
    [date-descriptor-parameter
     (ts-parameter ts)
     (api-key-parameter public-key)
     (hash-parameter ts public-key private-key)]))

(def ^:private date-descriptor-parameter "dateDescriptor=nextWeek")

(defn- ts-parameter [ts]
  (str "ts=" ts))

(defn- api-key-parameter [public-key]
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

(defn- create-hash [ts public-key private-key]
  (md5 (str ts private-key public-key)))

(defn- hash-parameter [ts public-key private-key]
  (str "hash=" (create-hash ts public-key private-key)))