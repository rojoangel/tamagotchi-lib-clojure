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
        (is (= :red (color/value->color {:type :decreasing :val 9}))))
      (testing
        "When value is exactly 10% its color is yellow"
        (is (= :yellow (color/value->color {:type :decreasing :val 10}))))
      (testing
        "When value is in lower 25% its color is yellow"
        (is (= :yellow (color/value->color {:type :decreasing :val 22}))))
      (testing
        "When value us exactly 25% its color is green"
        (is (= :green (color/value->color {:type :decreasing :val 25}))))
      (testing
        "Otherwise its color is green"
        (is (= :green (color/value->color {:type :decreasing :val 99})))))
    (testing
      "increasing values"
      (testing
        "When value is in upper 90% its color is red"
        (is (= :red (color/value->color {:type :increasing :val 99}))))
      (testing
        "When value is exactly 90% its color is yellow"
        (is (= :yellow (color/value->color {:type :increasing :val 90}))))
      (testing
        "When value is in upper 75% its color is yellow"
        (is (= :yellow (color/value->color {:type :increasing :val 78}))))
      (testing
        "When value is exactly 75% its color is green"
        (is (= :green (color/value->color {:type :increasing :val 75}))))
      (testing
        "Otherwise its color is green"
        (is (= :green (color/value->color {:type :increasing :val 1})))))))