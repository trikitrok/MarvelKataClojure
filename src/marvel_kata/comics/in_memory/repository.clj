(ns marvel-kata.comics.in-memory.repository)

(declare comics)

(defn get-all []
  comics)

(def ^:private comics
  (list
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/3/80/5432ca957660d.jpg", 
     :title "Hulk (2014) #9", 
     :price 3.99} 
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/6/40/5436c461dd05f.jpg", 
     :title "Miles Morales: Ultimate Spider-Man (2014) #8", 
     :price 3.99}))