package com.epam.practice.bio;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Solver {


    public Map<Section, List<Integer>> analyze(File input) throws IOException {
        Map<Section, List<Integer>> map = new HashMap<Section, List<Integer>>();

        try {
            Scanner sc = new Scanner(input);
            int m = sc.nextInt();
            String s = sc.next();
            boolean flag = false;
            int j=0;
            for (int i = m; i < s.length(); i++) {



                Section section = new Section(s.substring(j,i));
                for (Section sec:map.keySet()) {
                    if (sec.equals(section))
                        flag = true;
                }
                if (!flag){
                    List<Integer> list = new ArrayList<>();
                    list.add(j);
                map.put(section,list);
                flag = false;
                }   else {
                    Section currSect = section;
                    List<Integer> list = map.get(currSect);
                    list.add(j);
                    map.put(currSect, list);
                    flag =false;
                }

                j++;
            }






        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException();
        }

     return map;
    }


}
