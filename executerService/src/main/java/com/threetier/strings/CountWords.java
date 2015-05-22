package com.threetier.strings;

import java.util.HashMap;
import java.util.Map;

public class CountWords {

    public static void main(String[] args) {

        String[] words = {"word", "good", "Word", "great", "Ritesh", "riTesh"};

        Map<String, Integer> countMap = new HashMap<String, Integer>();

        for (String string : words) {

            String lowerCase = string.toLowerCase();
            if (countMap.containsKey(lowerCase)) {
                countMap.put(lowerCase, countMap.get(lowerCase) + 1);
            } else {
                countMap.put(lowerCase, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
