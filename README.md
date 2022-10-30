# Which CharSequence implementation is the fastest?
Measuring which CharSequence implementation can prepare a substring the quickest.  
Without outputting to stdout.  
CharBuffers seem to perform the same as the String pool.
```text
Benchmark                            Mode  Cnt  Score   Error  Units
StringBenchmarking.charBuffer        avgt    3  0.460 ± 0.020  ns/op
StringBenchmarking.stringCommonPool  avgt    3  0.471 ± 0.044  ns/op
StringBenchmarking.stringHeap        avgt    3  0.516 ± 0.882  ns/op
StringBenchmarking.stringBuilder     avgt    3  8.049 ± 2.325  ns/op
StringBenchmarking.customStringView  avgt    3  9.832 ± 3.247  ns/op

```
