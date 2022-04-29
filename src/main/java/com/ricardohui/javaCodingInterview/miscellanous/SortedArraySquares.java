class SortedArraySquares {

    //Assuming arr is a sorted array containing negative and positive numbers.
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];

        int j = 0;
        while (arr[j] < 0) j++;

        int i = j+1;
        int k = 0;
        while (k < arr.length) {
            if (j < 0 || (i < arr.length && Math.pow(arr[j], 2) > Math.pow(arr[i], 2))) {
                squares[k] = (int) Math.pow(arr[i], 2);
                i++;
            } else {
                squares[k] = (int) Math.pow(arr[j], 2);
                j--;
            }
            k++;
        }

        return squares;
    }

    public static void main(String[] args) {

        int[] result = SortedArraySquares.makeSquares(new int[]{-2, -1, 0, 2, 3});
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[]{-3, -1, 0, 1, 2});
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}