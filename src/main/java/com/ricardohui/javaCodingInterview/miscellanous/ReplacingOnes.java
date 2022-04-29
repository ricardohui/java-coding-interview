class ReplacingOnes {
    public static int findLength(int[] arr, int k) {
        int maxLength = 0;
        int windowStart = 0;
        int maxLengthOfOnes = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            int rightDigit = arr[windowEnd];
            if (rightDigit == 1) {
                maxLengthOfOnes++;
            }
            if (windowEnd - windowStart + 1 > maxLengthOfOnes + k) {

                if (arr[windowStart++] == 1) {
                    maxLengthOfOnes--;
                }

            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(ReplacingOnes.findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
        System.out.println(ReplacingOnes.findLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
    }
}