package com.epam.practice.bio;

import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Solver {

    public Map<Section, List<Integer>> analyze(File input) throws IOException {
        BufferedReader re = new BufferedReader(new FileReader(input));
        String subStringLen = re.readLine();
        if (subStringLen == null) {
            return Collections.emptyMap();
        }
        String molecule = re.readLine();
        if (molecule == null) {
            return Collections.emptyMap();
        }
        Map<Section, List<Integer>> result = getResult(molecule, Integer.parseInt(subStringLen));

        return result;
    }

    public Map<Section, List<Integer>> getResult(String input, int subLength) {
        TreeMap<Section, List<Integer>> result = new TreeMap<>();
        for (int i = 0; i < input.length() - subLength; i++) {
            String substring = input.substring(i, i + subLength);
            Section section = new Section(substring);

            List<Integer> positions = result.get(section);
            if (positions != null) {
                positions.add(i);
                result.put(section, positions);
            } else {
                LinkedList<Integer> newArray = new LinkedList<>();
                newArray.add(i);
                result.put(section, newArray);
            }

        }


        return result;
    }
}
