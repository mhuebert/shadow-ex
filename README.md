Repro:

1. `shadow-cljs watch browser bootstrap`
2. Open http://localhost:8000
   - you should see "result: 1"
3. Change the number in `shadow_ex/core.clj`'s `a-number` macro
4. Refresh page - the number will still be 1.