(ns euler.p6
  (:use euler.numbers))

(- (square (apply + (range 1 (inc 100)))) (apply + (map square (range 1 (inc 100))))) 