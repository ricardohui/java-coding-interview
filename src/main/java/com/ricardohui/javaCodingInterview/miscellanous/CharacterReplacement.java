import java.util.*;

class CharacterReplacement {

    public static int findLength(String str, int k) {
        int windowStart = 0;
        int maxRepeatingLetter = 0;
        int maxLength = 0;
        Map<Character, Integer> wordFrequencyMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            wordFrequencyMap.put(rightChar, wordFrequencyMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatingLetter = Math.max(maxRepeatingLetter, wordFrequencyMap.get(rightChar));
            if ( windowEnd - windowStart + 1  > maxRepeatingLetter + k) { // FIXME: need to handle scenario for two cc but does not increase the size
                char leftChar = str.charAt(windowStart);
                windowStart++;
                wordFrequencyMap.put(leftChar, wordFrequencyMap.get(leftChar) - 1);

            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        System.out.println(CharacterReplacement.findLength("aabccbb", 2));
        System.out.println(CharacterReplacement.findLength("abbcb", 1));
        System.out.println(CharacterReplacement.findLength("abccde", 1));
    }
}