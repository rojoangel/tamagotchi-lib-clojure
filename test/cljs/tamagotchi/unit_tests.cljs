(ns tamagotchi.unit-tests
  (:require
    [doo.runner :refer-macros [doo-tests]]
    [tamagotchi.core-test]))

(doo-tests
  'tamagotchi.core-test)