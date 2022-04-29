import java.util.Arrays;

class ShortestWindowSort {

    public static int sort(int[] arr) {
        int[] original = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);
        int i = 0;

        while (i < arr.length && original[i] == arr[i]) i++;

        int j = arr.length - 1;
        while (j >= 0 && original[j] == arr[j]) j--;

        int k = j - i + 1;
        if (k > 0) {
            return k;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(ShortestWindowSort.sort(new int[]{1, 2, 5, 3, 7, 10, 9, 12}));
        System.out.println(ShortestWindowSort.sort(new int[]{1, 3, 2, 0, -1, 7, 10}));
        System.out.println(ShortestWindowSort.sort(new int[]{1, 2, 3}));
        System.out.println(ShortestWindowSort.sort(new int[]{3, 2, 1}));
    }
}