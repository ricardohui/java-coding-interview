

import java.util.*;

class TripletSumCloseToTarget {

    public static int searchTriplet(int[] arr, int targetSum) {

        Arrays.sort(arr);

        int maxSumSoFar = 0;
        for (int i = 0; i < arr.length - 2; i++) {

            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];
                if (currentSum < targetSum && targetSum - currentSum < targetSum - maxSumSoFar) {
                    maxSumSoFar = currentSum;
                    left++;
                    right--;
                } else {
                    left++;
                }

            }

        }

        return maxSumSoFar;
    }

    public static void main(String[] args) {
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[]{-2, 0, 1, 2}, 2));

        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[]{-3, -1, 1, 2}, 1));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[]{1, 0, 1, 1}, 100));
    }

}