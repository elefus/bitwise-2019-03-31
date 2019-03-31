package com.epam.practice.bio;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Solver {

    public Map<Section, List<Integer>> analyze(File input) throws IOException {
        BufferedReader re = new BufferedReader(new FileReader(input));
        String string = re.readLine();
        if (string == null) {
            return Collections.emptyMap();
        }
        Map<Section, List<Integer>> result = getResult(string, ThreadLocalRandom.current().nextInt(5, 1001));

        throw new UnsupportedOperationException();
    }

    public Map<Section, List<Integer>> getResult(String input, int subLength) {
        return Collections.emptyMap();
    }
}
