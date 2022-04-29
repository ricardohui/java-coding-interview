import java.util.*;

class MinimumWindowSubstring {
    public static String findSubstring(String str, String pattern) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char c : pattern.toCharArray())
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);

        int windowStart = 0;
        int minWindowStart = 0;
        int minLength = Integer.MAX_VALUE;
        int charactersMatched = 0;

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);

            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) >= 0) {
                    charactersMatched++;
                }
            }

            while (charactersMatched == pattern.length()) {
                if (windowEnd - windowStart + 1 < minLength) {
                    minLength = Math.min(minLength, windowEnd - windowStart + 1);
                    minWindowStart = windowStart;
                }
                char leftChar = str.charAt(windowStart);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0) {
                        charactersMatched--;
                    }
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);

                }
                windowStart++;
            }
        }

        return minLength > str.length() ? "" : str.substring(minWindowStart, minWindowStart + minLength);
    }

    public static void main(String[] args) {
        System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("abdbca", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("adcad", "abc"));
    }
}