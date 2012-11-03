(ns euler.p9
  (use euler.numbers))

(reduce * (first (filter #(apply pythag? %)
                   (for [x (range 1 333) y  (range x 500)] [x y (- 1000 x y)]))))
