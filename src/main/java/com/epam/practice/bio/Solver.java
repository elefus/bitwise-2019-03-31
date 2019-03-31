package com.epam.practice.bio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solver {

    public Map<Section, List<Integer>> analyze(File input) throws IOException {
        Map<Section, List<Integer>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(input));
        int M = Integer.parseInt(br.readLine());
        int count = 0;
        while (br.ready()) {
            char c = (char) br.read();
            count++;
            if (sb.length() < M) {
                sb.append(c);
            }
            else {
                Section sec = new Section();
                sec.section = sb.toString();
                map.merge(sec, Collections.singletonList(count - M), (oldVal, newVal) -> Stream
                    .concat(oldVal.stream(),newVal.stream()).collect(Collectors.toList()));
                sb.append(c);
                sb = new StringBuilder(sb.subSequence(1,sb.length()));
            }
        }
        Section sec = new Section();
        sec.section = sb.toString();
        map.merge(sec, Collections.singletonList(++count - M), (oldVal, newVal) -> Stream
            .concat(oldVal.stream(),newVal.stream()).collect(Collectors.toList()));
        return map;
    }
}
