(ns marvel-kata.expected-results)

(def from-in-memory-repository
  (list
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/3/80/5432ca957660d.jpg", 
     :title "Hulk (2014) #9", 
     :price 3.99} 
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/6/40/5436c461dd05f.jpg", 
     :title "Miles Morales: Ultimate Spider-Man (2014) #8", 
     :price 3.99}))

(def from-marvel-api-repository
  (list
    {:price 4.99, 
     :thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/5/b0/546a60d17a3c1.jpg", 
     :title "Avengers Now! (2014) #1"} 
    {:price 3.99, 
     :thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/6/10/546a222e8bb54.jpg", 
     :title "Spider-Woman (2014) #2"} 
    {:price 3.99, 
     :thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg", 
     :title "Death of Wolverine: The Weapon X Program (2014) #4"} 
    {:price 3.99, 
     :thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/6/60/5436b7eb4119d.jpg", 
     :title "Moon Knight (2014) #10"} 
    {:price 3.99, 
     :thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/3/80/54295a612fe81.jpg", 
     :title "All-New X-Men (2012) #35"} 
    {:price 3.99, 
     :thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/6/a0/547c88c63e03b.jpg", 
     :title "Fantastic Four (2014) #14"} 
    {:price 4.99, 
     :thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/6/70/5436c5f25b4b7.jpg", 
     :title "Captain Marvel (2014) #10"} 
    {:price 3.99, 
     :thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/9/40/546b624eadf06.jpg", 
     :title "Axis: Hobgoblin (2014) #3"} 
    {:price 3.99, 
     :thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg", 
     :title "Storm (2014) #6"} 
    {:price 24.99, 
     :thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg", 
     :title "Thunderbolts Vol. 5: Punisher vs Thunderbolts (Trade Paperback)"} 
    {:price 3.99, 
     :thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/a/03/546b66874d410.jpg", 
     :title "Black Widow (2014) #13"} 
    {:price 3.99, 
     :thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/2/70/546a51012dd32.jpg", 
     :title "All-New Captain America (2014) #2"} 
    {:price 3.99, 
     :thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg", 
     :title "Scarlet Spiders (2014) #2"} 
    {:price 3.99, 
     :thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/2/c0/546b6efbedc7d.jpg", 
     :title "Deadpool (2012) #39"} 
    {:price 2.99, 
     :thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/5/d0/546b8453aa1a3.jpg", 
     :title "Marvel Universe Avengers Assemble Season Two (2014) #2"} 
    {:price 3.99, 
     :thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/b/03/542477834e53a.jpg", 
     :title "All-New X-Men (2012) #34"} 
    {:price 3.99, 
     :thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/6/70/546b75a16cd37.jpg", 
     :title "Deathlok (2014) #3"} 
    {:price 3.99, 
     :thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/3/c0/546b807b7652e.jpg", 
     :title "Inhuman (2014) #10"} 
    {:price 3.99, 
     :thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg", 
     :title "Avengers & X-Men: Axis (2014) #8"} 
    {:price 3.99, 
     :thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/c/30/546b79cca0e3b.jpg", 
     :title "Guardians of the Galaxy (2013) #22"}))
