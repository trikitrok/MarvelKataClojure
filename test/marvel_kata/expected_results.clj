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
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/3/80/5432ca957660d.jpg", 
     :title "Hulk (2014) #9", 
     :price 3.99} 
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/6/40/5436c461dd05f.jpg", 
     :title "Miles Morales: Ultimate Spider-Man (2014) #8", 
     :price 3.99} 
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg", 
     :title "Deadpool (2012) #38", 
     :price 0} 
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg", 
     :title "Thanos Vs. Hulk (2014) #1", 
     :price 0} 
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/8/f0/5432cd601e2ef.jpg", 
     :title "Inhuman (2014) #9", 
     :price 3.99} 
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/4/03/5473a12834f52.jpg", 
     :title "Angela: Asgard's Assassin (2014) #1", 
     :price 3.99} 
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg", 
     :title "CAPTAIN AMERICA: PEGGY CARTER, AGENT OF S.H.I.E.L.D. (2014) #1", 
     :price 0} 
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/1/f0/54739f858e981.jpg", 
     :title "All-New X-Factor (2014) #17", 
     :price 3.99} 
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/1/00/5473a4456859b.jpg", 
     :title "Angela: Asgard's Assassin (2014) #1 (Young Variant)", 
     :price 3.99} 
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg", 
     :title "Guardians 3000 (2014) #3", 
     :price 0} 
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg", 
     :title "Dark Tower: The Drawing of the Three - The Prisoner (2014) #5", 
     :price 3.99} 
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg", 
     :title "Men of Wrath (2014) #3", :price 0} 
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg", 
     :title "Avengers (2012) #39 (Tbd Artist Marvel 75th Anniversary Variant)", 
     :price 3.99} 
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/7/30/5436be496f95b.jpg", 
     :title "Cyclops (2014) #8", 
     :price 3.99} 
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/b/03/5466617d72b80.jpg", 
     :title "X-Men (2013) #22", 
     :price 0} 
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg", 
     :title "Axis: Revolutions (2014) #3", 
     :price 0} 
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/6/03/5424442644fc5.jpg", 
     :title "Iron Fist: The Living Weapon (2014) #7", 
     :price 3.99} 
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg", 
     :title "Thanos Vs. Hulk (2014) #1", 
     :price 3.99} 
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg", 
     :title "Death of Wolverine: The Weapon X Program (2014) #3", 
     :price 0} 
    {:thumbnail "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg", 
     :title "Miracleman (2014) #14", 
     :price 4.99}))
