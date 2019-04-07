package com.epam.practice.bio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class Solver {

    public Map<Section, List<Integer>> analyze(File input) throws IOException {
        List<String> strings = Files.readAllLines(input.toPath());
        String analyze = strings.get(1);
        Map<Section, List<Integer>> result = getResult(analyze, Integer.parseInt(strings.get(0)));

        return result;
    }

    public Map<Section, List<Integer>> getResult(String input, int subLength) {
        Map<Section, List<Integer>> result = new HashMap<>();

        int x = subLength;
        for (int i = 0; i < input.length() - subLength; i++) {
            String substring = input.substring(i, x);
            Section section = new Section(substring);
            Set<Section> sections = result.keySet();
            List<String> strings = sections.stream().map(Section::getSection).collect(Collectors.toList());
            if(!strings.isEmpty() && strings.contains(substring)) {
                List<Integer> positions = result.get(section);
                positions.add(i);
            } else {
                result.put(section, new ArrayList<>(i));
            }
            x++;
        }
        return result;
    }
}
