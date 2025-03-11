(ns plotly
  (:require [scicloj.kindly.v4.kind :as kind]
            [scicloj.clay.v2.api :as clay]
            [scicloj.tableplot.v1.plotly :as plotly]
            [tablecloth.api :as tc]))

(comment
  (clay/make! {:source-path "notebooks/plotly.clj"})
)

;; $x$

(-> (tc/concat
      (tc/dataset {:x [0 1], :y [0 1], :fun "$y=x^2$"})
      (tc/dataset {:x [0 1], :y [1 0], :fun "y=-x"}))
    (plotly/layer-line {:=x :x, :=y, :y :=color :fun})
    (plotly/plot)
    (assoc-in [:data 0 :name] "y<sup>2</sup> = -x")
    (assoc-in [:data 1 :name] "$y^2 = -x$")
    )

