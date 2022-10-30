package com.github.dehidehidehi.lowlatencyjava.charsequence;


import com.github.dehidehidehi.lowlatencyjava.charsequence.impl.StringViewImpl;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.nio.CharBuffer;
import java.util.concurrent.TimeUnit;

/**
 * Measuring which CharSequence implementation can prepare a substring the quickest.
 */
@State(Scope.Benchmark)
public class StringBenchmarking {

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .forks(1)
                .warmupIterations(2)
                .warmupTime(TimeValue.seconds(1))
                .measurementBatchSize(1)
                .measurementIterations(3)
                .measurementTime(TimeValue.seconds(1))
                .mode(Mode.AverageTime)
                .timeUnit(TimeUnit.NANOSECONDS)
                .build();
        new Runner(options).run();
    }

    @Benchmark
    public void stringCommonPool() {
        "Hello world!".subSequence(0, 5);
    }

    @Benchmark
    public void stringHeap() {
        new String("Hello world!").subSequence(0, 5);
    }

    @Benchmark
    public void charBuffer() {
        final char[] chars = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!'};
        CharBuffer.wrap(chars).subSequence(0, 5);
    }

    @Benchmark
    public void stringBuilder() {
        new StringBuilder("Hello World!").subSequence(0, 5);
    }

    @Benchmark
    public void customStringView() {
        final char[] chars = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!'};
        new StringViewImpl().set(CharBuffer.wrap(chars), 0, 5);
    }
}
