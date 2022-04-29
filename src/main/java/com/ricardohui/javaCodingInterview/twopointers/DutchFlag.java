class DutchFlag {

    public static void sort(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            while (arr[right] == 2) right--;
            if (arr[left] == 2) {
                swap(arr, left, right);
                right--;
            }
            left++;

        }

        left = 0;
        while (left < right) {
            while (arr[right] == 1) right--;
            if (arr[left] == 1) {
                swap(arr, left, right);
                right--;
            }
            left++;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 1, 0};
        DutchFlag.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[]{2, 2, 0, 1, 2, 0};
        DutchFlag.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }
}