package com.epam.practice.substring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class NaiveSolver implements Solver {

    @Override
    public int analyze(File input) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String s = reader.readLine();
            if (s == null) {
                return 0;
            }
            int n = s.length();
            Set<Character> set = new HashSet<>();
            int ans = 0, i = 0, j = 0;
            while (i < n && j < n) {
                if (!set.contains(s.charAt(j))){
                    set.add(s.charAt(j++));
                    ans = Math.max(ans, j - i);
                }
                else {
                    set.remove(s.charAt(i++));
                }
            }
            return ans;
        }
    }
}

