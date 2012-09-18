(ns euler.p4
  (use euler.numbers))

(apply max (filter palindromic? (for [x (range 999 99 -1) y (range x 99 -1)] (* x y) )))
