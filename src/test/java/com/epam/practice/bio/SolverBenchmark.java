package com.epam.practice.bio;

import com.epam.practice.AbstractTestWithResources;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@SuppressWarnings("unused")
public class SolverBenchmark extends AbstractTestWithResources {

    @Param({"100k_10.txt", "200k_100.txt", "500k_500.txt", "1kk_999.txt", "2kk_500.txt"})
    private String source;

    @Benchmark
    public Map<?,?> plokhoiSolver() throws Exception {
        Solver solver = new Solver();
        return solver.analyze(getTestFile(SolverBenchmark.class, "benchmarks/" + source));
    }

    @Test
    void benchmark() throws Exception {
        Options options = new OptionsBuilder().include(SolverBenchmark.class.getName() + ".*")
                                              .mode(Mode.AverageTime)
                                              .timeUnit(TimeUnit.SECONDS)
                                              .warmupTime(TimeValue.seconds(1))
                                              .warmupIterations(2)
                                              .measurementTime(TimeValue.seconds(1))
                                              .measurementIterations(2)
                                              .threads(1)
                                              .forks(1)
                                              .shouldFailOnError(true)
                                              .shouldDoGC(true)
                                              .build();
        new Runner(options).run();
    }
}
