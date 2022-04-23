class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int i = 0, j = k;
        int currentMax = 0;
        while (i<k){
            currentMax+=arr[i++];
        }

        int windowSum = currentMax;
        i = 1;

        while (i <= arr.length - k) {
            windowSum = windowSum - arr[i-1] + arr[j];
            if (windowSum> currentMax) {
                currentMax = windowSum;
            }

            i++;
            j++;
        }
        return currentMax;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                                   + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                                   + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}