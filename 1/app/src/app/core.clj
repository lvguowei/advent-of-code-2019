(ns app.core)

(defn -main
  ""
  []
  (let [input (slurp "resources/input.txt")
        masses (clojure.string/split-lines input)]
    (reduce
     +
     (map
      #(- (Math/floor (/ (Integer/parseInt %) 3)) 2)
      masses))))
