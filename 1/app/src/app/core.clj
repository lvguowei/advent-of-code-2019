(ns app.core)

(defn read-input
  []
  "Returns list of masses"
  (let [input (slurp "resources/input.txt")
        masses (clojure.string/split-lines input)]
    (map #(Integer/parseInt %) masses)))

(defn fuel
  [mass]
  (- (Math/floor (/ mass 3)) 2))

(defn fuel-r
  ""
  [mass]
  (loop [m mass
         s 0]
    (let [f (fuel m)]
      (if (<= f 0)
        s
        (recur f (+ s f))))))

(defn start
  ""
  []
  (let [masses (read-input)]
    (reduce
     +
     (map fuel masses))))

(defn start2
  ""
  []
  (let [masses (read-input)]
    (reduce + (map fuel-r masses))))
