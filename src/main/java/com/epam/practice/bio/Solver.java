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

    public Solver() {
    }

    public Map<Section, List<Integer>> analyze(File input) throws IOException {
        FileReader fileReader = new FileReader(input);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Map<Section, List<Integer>> result = new HashMap<>();
        int n = Integer.parseInt(bufferedReader.readLine());
        String line = bufferedReader.readLine();


        for (int i = 0; i < line.length() - 1; i++) {
            String substring = line.substring(i, i + n);
            Section section = new Section(n, substring);

            List<Integer> indexes = result.getOrDefault(section, new ArrayList<>());
            indexes.add(i);
            result.put(section, indexes);

        }

        return result;
    }
}
