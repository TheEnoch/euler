(ns euler.p1)

(apply + (filter #(or (= 0 (mod % 3))
                (= 0 (mod % 5)))
           (range 1000)))