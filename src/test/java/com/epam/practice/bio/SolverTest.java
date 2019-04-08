package com.epam.practice.bio;

import com.epam.practice.AbstractTestWithResources;
import lombok.Value;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolverTest extends AbstractTestWithResources {

    private Solver solver;

    @BeforeEach
    void setUp() {
        solver = new Solver();
    }

    @Test
    void baseTest() throws Exception {
        File source = getTestFile(SolverTest.class, "baseTest.txt");

        Map<Section, List<Integer>> result = solver.analyze(source);

        assertEquals(4, result.size());
        assertThat(result, hasEntry(new DummySection("ACACA"), Arrays.asList(0, 2)));
        assertThat(result, hasEntry(new DummySection("CACAC"), Arrays.asList(1, 3)));
        assertThat(result, hasEntry(new DummySection("ACACG"), singletonList(4)));
        assertThat(result, hasEntry(new DummySection("CACGT"), singletonList(5)));
    }

    @Value
    private static class DummySection extends Section {
        String section;
    }
}