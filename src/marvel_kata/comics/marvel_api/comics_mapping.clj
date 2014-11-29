(ns marvel-kata.comics.marvel-api.comics-mapping)

(declare 
  create-comics
  extract-comics-data)

(def to-comics 
  (comp create-comics extract-comics-data))

(defn- path [thumbnail]
  (str (:path thumbnail) "." (:extension thumbnail)))

(defn- price [prices]
  (:price (first prices)))

(defn- create-comic [thumbnail title price]
  {:thumbnail thumbnail :title title :price price})

(def create-comics
  (partial map
           #(create-comic (path (:thumbnail %))
                          (:title %)
                          (price (:prices %)))))

(defn extract-comics-data [mapped-data]
  (get-in mapped-data [:body :data :results]))

(defn to-comics [mapped-data]
  (create-comics 
    (extract-comics-data mapped-data)))