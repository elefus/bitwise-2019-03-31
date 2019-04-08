package com.epam.theory;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.ChainedOptionsBuilder;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Fork(1)
@Threads(1)
@Measurement(iterations = 2, time = 1)
@Warmup(iterations = 2, time = 1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
public class SignOfValueBenchmark {

    private int[] values;

    @Setup
    public void setUp() {
        values = ThreadLocalRandom.current().ints(100).toArray();
        System.out.println(Arrays.toString(values));

    }

    @Benchmark
    public int ternaryOperator() {
        int sum = 0;
        for (int value : values) {
            sum += value < 0 ? -1 : 0;
        }
        return sum;
    }

    @Benchmark
    public int bitwiseOperator() {
        int sum = 0;
        for (int value : values) {
            sum += -(value >>> 31);
        }
        return sum;
    }

    public static void main(String[] args) throws RunnerException {
        ChainedOptionsBuilder options = new OptionsBuilder().include(SignOfValueBenchmark.class.getName() + ".*");
        new Runner(options.build()).run();
    }
}
