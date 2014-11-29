(ns marvel-kata.core-test
  (:use midje.sweet)
  (:use [marvel-kata.core])
  (:require [marvel-kata.comics.marvel-api.repository :as marvel-api-repository]
            [marvel-kata.comics.in-memory.repository :as in-memory-repository]
            [marvel-kata.expected-results :as expected-comics]))

(facts 
  "about obtaining comics"
  
  (fact 
    "it can obtain comics from marvel api repository"
    (comics 
      marvel-api-repository/get-all) => expected-comics/from-marvel-api-repository)
  
  (fact 
    "it can obtain comics from in memory repository"
    (comics 
      in-memory-repository/get-all) => expected-comics/from-in-memory-repository))
