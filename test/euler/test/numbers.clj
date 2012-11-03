(ns euler.test.numbers
  (:use midje.sweet)
  (:use euler.numbers))

(fact (factor? 1 1) => true)
(fact (factor? 1 2) => true)
(fact (factor? 3 2) => false)
(fact (factor? 8 32) => true)

;;factors
(fact (factors 1) => #{1})
(fact (factors 2) => #{1 2})
(fact (factors 36) => #{1 2 3 4 6 9 12 18 36})

;;prime?
(fact (prime? 1) => false)
(fact (prime? 2) => true)
(fact (prime? 29) => true)
(fact (prime? 30) => false)

;;prime-till
(fact (prime-till 6) => [ 2 3 5 ])

;;pythag?
(fact (pythag? 3 4 5) => true)
(fact (pythag? 4 3 5) => false)
(fact (pythag? 1 5 20) => false)
