class MinSizeSubArraySum {
    public static int findMinSubArray1(int S, int[] arr) {
        int minLength = 1;
        while (minLength <= arr.length){

            for (int i = 0; i <= arr.length - minLength; i++) {
                int sumForThisRound = 0;

                for (int j = i; j < i+minLength; j++) {
                    sumForThisRound += arr[j];
                }

                if (sumForThisRound >= S){
                    return minLength;
                }
            }

            minLength++;
        }
        return -1;
    }

    public static int findMinSubArray(int S, int[] arr) {
        int windowSum = 0, minLength = Integer.MAX_VALUE;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            while (windowSum >= S) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;

    }

    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
//        result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
//        System.out.println("Smallest subarray length: " + result);
//        result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
//        System.out.println("Smallest subarray length: " + result);
    }
}