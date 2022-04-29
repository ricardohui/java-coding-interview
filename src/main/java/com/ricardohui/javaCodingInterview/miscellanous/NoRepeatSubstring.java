

import java.util.*;

class NoRepeatSubstring {
    public static int findLength(String str) {
        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> wordFrequencyMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            wordFrequencyMap.put(rightChar, wordFrequencyMap.getOrDefault(rightChar, 0) + 1);
            while(wordFrequencyMap.get(rightChar)!=1){
                char leftChar = str.charAt(windowStart);
                wordFrequencyMap.put(leftChar, wordFrequencyMap.get(leftChar) - 1);
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }
}