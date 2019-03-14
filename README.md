Repro:

1. `shadow-cljs watch browser bootstrap`
2. Open http://localhost:8000
   - you should see `(m/current-time) :=> 1`
3. Change the number in the `shadow-ex.macros/a-number` macro
4. Refresh page - the number will still be 1.