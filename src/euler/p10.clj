(ns euler.p10
  (:use 'euler.numbers))

(reduce + (prime-till 2000000))