import java.util.*;

class QuadrupleSumToTarget {

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> quadruplets = new ArrayList<>();
        if (arr.length < 3) {
            return quadruplets;
        }

        for (int i = 0; i < arr.length-3; i++) {
            for (int j = i+1; j < arr.length-2; j++) {
                int left = j + 1, right = arr.length - 1;
                while (left < right) {
                    int currentSum = arr[i] + arr[j] + arr[left] + arr[right];
                    if (currentSum == target){
                        quadruplets.add(Arrays.asList(arr[i], arr[j], arr[left++], arr[right--]));
                    } else if (currentSum > target) {
                        right--;
                    }else {
                        left++;
                    }
                }
            }
        }
        return quadruplets;
    }
    public static void main(String[] args) {
        System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
        System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
    }
}