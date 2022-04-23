import java.util.*;

class TripletSumToZero {

    public static List<List<Integer>> searchTriplets(int[] arr) {
        int[] sortedArray = Arrays.stream(arr).sorted().toArray();
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < sortedArray.length - 2; i++) {
            int fixedNumber = sortedArray[i];
            if (i != 0 && sortedArray[i] == sortedArray[i - 1]) {
                continue;
            }

            int left = i + 1, right = sortedArray.length - 1;
            while (left < right) {
                if (-sortedArray[left] - sortedArray[right] > fixedNumber) {
                    left++;
                } else if (-sortedArray[left] - sortedArray[right] < fixedNumber) {
                    right--;
                } else {
                    // one triplet found
                    triplets.add(Arrays.asList(sortedArray[i], sortedArray[left++], sortedArray[right--]));
                    while (left < right && arr[left] == arr[left - 1]) left++;
                    while (left < right && arr[right] == arr[right + 1]) right--;

                }
            }

        }
        return triplets;
    }

    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println(TripletSumToZero.searchTriplets(new int[]{-5, 2, -1, -2, 3}));


    }
}