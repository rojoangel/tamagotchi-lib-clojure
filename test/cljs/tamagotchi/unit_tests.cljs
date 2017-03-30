(ns tamagotchi.unit-tests
  (:require
    [doo.runner :refer-macros [doo-tests]]
    [tamagotchi.core-test]
    [tamagotchi.color-test]))

(doo-tests
  'tamagotchi.core-test
  'tamagotchi.color-test)