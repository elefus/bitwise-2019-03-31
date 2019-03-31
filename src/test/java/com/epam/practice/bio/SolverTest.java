package com.epam.practice.bio;

import com.epam.practice.AbstractTestWithResources;
import lombok.Value;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolverTest extends AbstractTestWithResources {

    private Solver solver;

    @BeforeEach
    void setUp() {
        solver = new Solver();
//        throw new UnsupportedOperationException();
    }

    @Test
    void baseTest() throws Exception {
        File source = getTestFile(SolverTest.class, "baseTest.txt");

        Map<Section, List<Integer>> result = solver.analyze(source);

        assertEquals(6, result.size());
        hasEntry(new Section("AC"), singletonList(0));
        hasEntry(new Section("CC"), Arrays.asList(1, 2, 5));
        hasEntry(new Section("CG"), singletonList(3));
        hasEntry(new Section("CT"), singletonList(6));
        hasEntry(new Section("GC"), Arrays.asList(4, 8));
        hasEntry(new Section("TG"), singletonList(7));
    }


    @Test
    void createAndToStringCorrect() {
        String actga = "ACTGA";
        Section section = new Section(actga);

        assertEquals(actga, section.toString());

        String second = "ACTGACGTAGCTAGCTAGCTACGTGTCCTAGCTAGCTACGTCTAGCTAGCTACGGTGTCCTAGCTACGGTGT";
        assertEquals(second, new Section(second).toString());
    }

//    @Value
//    private static class DummySection extends Section {
//        String section;
//    }
}
