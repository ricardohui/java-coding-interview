class RemoveDuplicates {

    public static int remove(int[] arr) {
        int nonDuplicateNextInsert = 1, nextReaderPosition = 1;
        while (nextReaderPosition < arr.length) {

            if(arr[nextReaderPosition]!=arr[nonDuplicateNextInsert -1 ]){
                arr[nonDuplicateNextInsert] = arr[nextReaderPosition];
                nonDuplicateNextInsert++;
            }

            nextReaderPosition++;
        }
        return nonDuplicateNextInsert ;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(RemoveDuplicates.remove(arr));
    }
}
