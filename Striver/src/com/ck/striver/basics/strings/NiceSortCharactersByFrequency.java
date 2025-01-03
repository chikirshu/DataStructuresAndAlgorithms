package com.ck.striver.basics.strings;

import java.util.*;

// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-strings/sort-characters-by-frequency/submissions
public class NiceSortCharactersByFrequency {

    public static void main(String[] args){
        String s = "tree";
        System.out.println(listByFrequency(s));
    }

    /*
        Time Complexity:O(n log n) where n is the length of the string, due to sorting the frequency entries
        Space Complexity:O(n) for storing frequency counts and final result list
    */
    private static List<Character> listByFrequency(String s) {
        List<Character> finalList = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int frequency = map.getOrDefault(ch, 0) + 1;
            map.put(ch, frequency);
        }
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, (o1, o2) -> {
            int compare = o2.getValue().compareTo(o1.getValue());
            if(compare==0) return o1.getKey().compareTo(o2.getKey());
            return compare;
        });

        for(Map.Entry<Character, Integer> entry : entryList){
            finalList.add(entry.getKey());
        }

        return finalList;
    }

    // Striver way

    /*
        Time Complexity: The time complexity of this solution is O(n + k log k) where n is the length of the string and k is the constant 26 for the alphabet
        Space Complexity: The space complexity is O(k), where k is the constant 26 for the frequency array.
    */
    // Helper class to store frequency and character
    class Pair {
        int freq;
        char ch;
        Pair(int f, char c) {
            this.freq = f;
            this.ch = c;
        }
    }

    public List<Character> frequencySort(String s) {
        // Frequency array for characters 'a' to 'z'
        Pair[] freq = new Pair[26];
        for (int i = 0; i < 26; i++) {
            freq[i] = new Pair(0, (char)(i + 'a'));
        }

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a'].freq++;
        }

        // Sort based on frequency (descending) and alphabetically (ascending)
        Arrays.sort(freq, (p1, p2) -> {
            if (p1.freq != p2.freq) return p2.freq - p1.freq;
            return p1.ch - p2.ch;
        });

        // Collect result
        List<Character> result = new ArrayList<>();
        for (Pair p : freq) {
            if (p.freq > 0) result.add(p.ch);
        }
        return result;
    }
}
