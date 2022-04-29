import java.util.*;

class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        int windowStart = 0;
        int matched = 0;
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();
        List<Integer> resultIndices = new ArrayList<Integer>();

        for (char c : pattern.toCharArray())
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
             char rightChar = str.charAt(windowEnd);

            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0) {
                    matched++;
                }
            }

            if(charFrequencyMap.size() == matched){
                resultIndices.add(windowStart);
            }

            if (windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart++);

                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar)==0) {
                        matched--;
                    }
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }

            }
        }


        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
        System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
    }
}