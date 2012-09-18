(ns euler.p2
  (:use euler.numbers))

(apply + (filter even? (take-while #(< % 4000000) (fib))))