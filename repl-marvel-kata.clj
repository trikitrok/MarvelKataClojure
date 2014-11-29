(require '[clj-http.client :as client])

(def data
  (client/get "http://gateway.marvel.com:80/v1/public/comics?dateDescriptor=nextWeek&ts=987&apikey=97f295907072a970c5df30d73d1f3816&hash=abfa1c1d42a73a5eab042242335d805d"))

data

(:body data)

(get-in {:body {:koko "a"}} [:body :koko])

(defn get-comics-data-as-json-map [url]
  (client/get url {:as :json}))

(def json-as-map
  (get-comics-data-as-json-map
   "http://gateway.marvel.com:80/v1/public/comics?dateDescriptor=nextWeek&ts=987&apikey=97f295907072a970c5df30d73d1f3816&hash=abfa1c1d42a73a5eab042242335d805d"))


json-as-map

;:thumbnail :title :prices

(sort (keys (nth (get-in json-as-map [:body :data :results]) 0)))

(defn path [thumbnail]
  (str (:path thumbnail) "." (:extension thumbnail)))

(defn price [prices]
  (:price (first prices)))

(path {:path "http://i.annihil.us/u/prod/marvel/i/mg/3/80/5432ca957660d", :extension "jpg"})

(price [{:type "printPrice", :price 3.99}])

(defn create-comic [thumbnail title price]
  {:thumbnail thumbnail :title title :price price})

(create-comic "koko" "moko" "loko")

(def create-comics
  (partial map
           #(create-comic (path (:thumbnail %))
                          (:title %)
                          (price (:prices %)))))

(defn extract-comics-data [mapped-data]
  (get-in mapped-data [:body :data :results]))

(extract-comics-data {:body {:data {:results []}}})


(create-comics (extract-comics-data json-as-map))

(def comics
  (comp create-comics extract-comics-data))

(comics json-as-map)

;;Url: http://gateway.marvel.com:80/v1/public/comics?dateDescriptor=nextWeek&ts=XXX&apikey=XXX&hash=XXX
;;ts = timestamp o cualquier número.
;;apiKey = public key
;;hash = md5(ts+privateKey+publicKey)
;;http://gateway.marvel.com:80/v1/public/comics?dateDescriptor=nextWeek&ts=987&apikey=97f295907072a970c5df30d73d1f3816&hash=abfa1c1d42a73a5eab042242335d805d

;;Public Key: 97f295907072a970c5df30d73d1f3816
;;Private key: ed54a875c0dffad1fa6af84e66ff104434a1c6cc

(def ts 987)
(def public-key "97f295907072a970c5df30d73d1f3816")
(def private-key "ed54a875c0dffad1fa6af84e66ff104434a1c6cc")

(def comics-api-url "http://gateway.marvel.com:80/v1/public/comics")

(def date-descriptor-parameter "dateDescriptor=nextWeek")

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
      (new java.math.BigInteger 1 (.digest hash-bytes)) ; Positive and the size of the number
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

(gen-api-call-parameters ts public-key private-key)

(defn gen-api-call-url [ts public-key private-key]
  (clojure.string/join
   "?"
   [comics-api-url
    (gen-api-call-parameters ts public-key private-key)]))

(gen-api-call-url ts public-key private-key)

(comics
 (get-comics-data-as-json-map
 (gen-api-call-url ts public-key private-key)))
