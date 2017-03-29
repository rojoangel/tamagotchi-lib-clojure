(ns tamagotchi.core-test
  (:require
    [clojure.test :refer :all]
    [tamagotchi.core :as tamagotchi]))

(deftest
  about-tamagotchi
  (testing
    "about feeding"
    (testing
      "When I feed it, it's hungriness is decreased"
      (let [tamagotchi (tamagotchi/create :hungriness 6)]
        (is (= 5 (:hungriness (tamagotchi/feed tamagotchi))))))
    (testing
      "When I feed it, it's fullness is increased"
      (let [tamagotchi (tamagotchi/create :fullness 6)]
        (is (= 7 (:fullness (tamagotchi/feed tamagotchi)))))))
  (testing
    "about playing"
    (testing
      "When I play with it, it's happiness is increased"
      (let [tamagotchi (tamagotchi/create :happiness 6)]
        (is (= 7 (:happiness (tamagotchi/play tamagotchi))))))
    (testing
      "When I play with it, it's tiredness is increased"
      (let [tamagotchi (tamagotchi/create :tiredness 6)]
        (is (= 7 (:tiredness (tamagotchi/play tamagotchi)))))))
  (testing
    "about putting to bed"
    (testing
      "When i put it to bed, it's tiredness is decreased"
      (let [tamagotchi (tamagotchi/create :tiredness 6)]
        (is (= 5 (:tiredness (tamagotchi/put-to-bed tamagotchi)))))))
  (testing
    "about making poop"
    (testing
      "When i make it poop, it's fullness is decreased"
      (let [tamagotchi (tamagotchi/create :fullness 6)]
        (is (= 5 (:fullness (tamagotchi/make-poop tamagotchi)))))))
  (testing
    "about changing needs over time"
    (testing
      "When time passes, its tiredness is increased"
      (let [tamagotchi (tamagotchi/create :tiredness 6)]
        (is (= 7 (:tiredness (tamagotchi/tic tamagotchi))))))
    (testing
      "When time passes, its hungriness is increased"
      (let [tamagotchi (tamagotchi/create :hungriness 6)]
        (is (= 7 (:hungriness (tamagotchi/tic tamagotchi))))))
    (testing
      "When time passes, its happiness is decreased"
      (let [tamagotchi (tamagotchi/create :happiness 6)]
        (is (= 5 (:happiness (tamagotchi/tic tamagotchi)))))))
  (testing
    "about not going beyond min & max attribute values"
    (testing
      "When fullness reaches minimum it is not further decreased"
      (let [tamagotchi (tamagotchi/create :fullness tamagotchi/min-attribute-value)]
        (is (= tamagotchi/min-attribute-value (:fullness (tamagotchi/make-poop tamagotchi))))))
    (testing
      "When hungriness reaches minimum it is not further decreased"
      (let [tamagotchi (tamagotchi/create :hungriness tamagotchi/min-attribute-value)]
        (is (= tamagotchi/min-attribute-value (:hungriness (tamagotchi/feed tamagotchi))))))
    (testing
      "When tiredness reaches minimum it is not further decreased"
      (let [tamagotchi (tamagotchi/create :tiredness tamagotchi/min-attribute-value)]
        (is (= tamagotchi/min-attribute-value (:tiredness (tamagotchi/put-to-bed tamagotchi))))))
    (testing
      "When happiness reaches maximum it is not further increased"
      (let [tamagotchi (tamagotchi/create :happiness tamagotchi/max-attribute-value)]
        (is (= tamagotchi/max-attribute-value (:happiness (tamagotchi/play tamagotchi))))))))