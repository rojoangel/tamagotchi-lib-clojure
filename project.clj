(defproject tamagotchi "0.0.1-SNAPSHOT"
  :description "tamagotchi library"
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :source-paths ["src/cljc"]
  :test-paths ["test/cljc"]
  :profiles {:dev {:dependencies [[midje "1.7.0"]]}
             ;; You can add dependencies that apply to `lein midje` below.
             ;; An example would be changing the logging destination for test runs.
             :midje {}})
             ;; Note that Midje itself is in the `dev` profile to support
             ;; running autotest in the repl.

  
