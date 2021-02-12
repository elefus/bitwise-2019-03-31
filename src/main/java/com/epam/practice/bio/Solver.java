package com.epam.practice.bio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solver {

    public Map<Section, List<Integer>> analyze(File input) throws IOException {
        Map<Section, List<Integer>> result = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            int m = Integer.valueOf(reader.readLine());
            String line;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length() - m + 1; i++) {
                    String currentSection = line.substring(i, i + m);
                    Section section = new Section(currentSection);
                    if (result.containsKey(section)) {
                        List<Integer> value = result.get(section);
                        value.add(i);
                    } else {
                        List<Integer> value = new ArrayList<>();
                        result.put(section, value);
                        value.add(i);
                    }
                }
            }
        }

        return result;
    }
}
