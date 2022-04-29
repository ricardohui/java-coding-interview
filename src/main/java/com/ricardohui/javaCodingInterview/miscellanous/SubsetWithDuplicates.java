import java.util.*;

class SubsetWithDuplicates {

    public static List<List<Integer>> findSubsets(int[] nums) {
        // sort the numbers to handle duplicates
        Arrays.sort(nums);
        
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(Arrays.asList());
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                List<Integer> subset = new ArrayList<>();
                for (int k = j; k <= i; k++) {
                    subset.add(nums[k]);
                }
                if (!subset.isEmpty()){
                    subsets.add(subset);
                }

            }
        }

        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}