(defproject tamagotchi "0.0.1-SNAPSHOT"
  :description "tamagotchi library"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.227"]]

  :plugins [[lein-cljsbuild "1.1.5"]]

  :source-paths ["src/cljc"]
  :test-paths ["test/cljc"]
  :profiles {:dev   {:dependencies [[midje "1.8.3"]]
                     :plugins      [[lein-midje "3.2.1"]
                                    [lein-doo "0.1.6"]
                                    [lein-auto "0.1.2"]]}
             ;; You can add dependencies that apply to `lein midje` below.
             ;; An example would be changing the logging destination for test runs.
             ;; Note that Midje itself is in the `dev` profile to support
             ;; running autotest in the repl.
             :midje {}}

  :cljsbuild
  {:builds
   [{:id           "unit-tests"
     :source-paths ["src/cljc" "test/cljc" "test/cljs"]
     :compiler     {:main          'tamagotchi.unit-tests
                    :output-to     "resources/public/js/compiled/unit-tests.js"
                    :target        :nodejs
                    :optimizations :none
                    }}

    {:id           "min"
     :source-paths ["src/cljc"]
     :compiler     {:main            tamagotchi.core
                    :output-to       "resources/public/js/compiled/app.js"
                    :optimizations   :advanced
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}
    ]}
  )

  
