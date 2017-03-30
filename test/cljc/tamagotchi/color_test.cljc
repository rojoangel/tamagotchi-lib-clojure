(ns tamagotchi.color-test
  (:require
    #?@(:clj  [[clojure.test :refer :all]
               [tamagotchi.color :as color]]
        :cljs [[cljs.test :refer-macros [deftest is testing]]
               [tamagotchi.color :as color]])))
(deftest
  about-tamagotchi
  (testing
    "color"
    (testing
      "decreasing values"
      (testing
        "When value is in lower 10% its color is red"
        (is (= :red (color/value->color {:type :decreasing :val 9} identity))))
      (testing
        "When value is exactly 10% its color is yellow"
        (is (= :yellow (color/value->color {:type :decreasing :val 10} identity))))
      (testing
        "When value is in lower 25% its color is yellow"
        (is (= :yellow (color/value->color {:type :decreasing :val 22} identity))))
      (testing
        "When value us exactly 25% its color is green"
        (is (= :green (color/value->color {:type :decreasing :val 25} identity))))
      (testing
        "Otherwise its color is green"
        (is (= :green (color/value->color {:type :decreasing :val 99} identity)))))))