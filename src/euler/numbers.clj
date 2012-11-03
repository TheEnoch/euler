(ns euler.numbers)

(defn fib-till
  "returns the fibonacci sequence up to a certain value"
  ([] [1 2])
  ([n] (loop [vals (fib-till)]
          (let [next-term (+ (vals (- (count vals) 1))
                             (vals (- (count vals) 2))
                             )]
            (cond (>= next-term n) vals
                  :else (recur (conj vals next-term)))))))

(defn fib
  "Lazy Fibonacci sequence"
  []
  (concat [1 1]
          ((fn rest-terms [last-one last-but-one]
             (let [next-term (+' last-one last-but-one)]
               (lazy-seq (cons next-term (rest-terms next-term last-one)))))
           1 1)))

(defn factor?
  "checks n to see if it is a factor of k"
  [n k]
  (zero? (mod k n)))

(defn factors
  "returns a sequence of factors"
  [n] (loop [k 1 fcts #{}]
        (cond (> (* k k) n) fcts
              :else (if (factor? k n)
                      (recur (inc k) (conj fcts k (/ n k)))
                      (recur (inc k) fcts)))))

(defn digits
  "turns a number into a sequence of digits"
 [n] (map #(Integer/parseInt (str %)) (seq (str n))))

(defn conj-next-prime
  "takes a vector of primes and returns a vector 'conj'ed with the next prime")

(defn next-prime?
  "checks a candidate against a collection of previous primes to see if it is prime"
  [n coll] (not (some (fn [p] (factor? p n)) coll)))

(defn next-prime
  "takes a vector of primes and returns the next prime"
  [coll] (let [first-candidate (+ (last coll) 2)
               candidates (iterate (partial + 2) first-candidate)]
           (first (filter #(next-prime? % coll) candidates))))

(defn primes
  "retuns a lazy sequence of primes"
  ([] (concat [2 3 5] (primes [2 3 5])))
  ([so-far] (let [next-p (next-prime [so-far])
                  next-so-far (conj so-far next-p)]
              (lazy-seq ())) ))

(defn prime?
  "checks a number to see if it is prime"
  [n]
  (= 2 (count (factors n) )))

(defn prime-till
  "returns a sequence of prime numbers up to a certain value"
  [n] (take n (filter prime? (range 2 n))) )

(defn prime-nth
  "returns a sequence of primes until the nth prime number"
  [n] (take n (filter prime? (range))))

(defn highest-prime-factor
  "returns the highest prime factor of n"
  [n] (apply max (filter prime? (factors n))))

(defn palindromic?
  "checks to see whether a number is palindromic"
  [n] (if (= (seq (str n)) (reverse (str n))) n false))

(defn prime-factors
  "returns a sequence of the prime factors of a number"
  [n] (loop [k n
             PF []
             P  (prime-till (inc n))]
        (let [p (first P)]
          (cond
           (empty? P) PF
           (zero? (mod k p)) (recur (/ k p)
                                    (conj PF p)
                                    P)
           :else (recur k
                        PF
                        (rest P)
                        )))))

(defn GCD
  "returns the Greatest Common Divisor of two numbers"
  [n k] (let [r (rem n k)] (if (= r 0) k (recur k r))))

(defn LCM
  ([n k] (/ (* n k) (GCD n k)))
  ([n k & rst] (reduce LCM (conj rst k n))))

(defn square
  "returns the square of a number"
  [n] (* n n))

(defn pythag?
  "checks to see if a set of three numbers is a pythagorean triplet"
  [x y z] (cond 
           (not (< x y z)) false
           (not= (* z z)
                 (+ (* x x)
                    (* y y))) false
            :else true))

