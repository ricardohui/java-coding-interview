import java.util.*;

class SubarrayProductLessThanK {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<target) subarrays.add(Arrays.asList(arr[i]));
        }


        for (int left = 0; left < arr.length - 1; left++) {
            int currentProduct = arr[left] * arr[left+1];
            if (currentProduct < target) {
                subarrays.add(Arrays.asList(arr[left], arr[left+1]));
            }
        }

        return subarrays;
    }

    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }
}