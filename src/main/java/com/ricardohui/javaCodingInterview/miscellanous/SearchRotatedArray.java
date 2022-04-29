
class SearchRotated{

    static int binarySearch(int[] arr, int key, int start, int end){
        if (start > end){
            return -1;
        }

        int mid = (end - start) / 2  + start;

        if (arr[mid]==key){
            return mid;
        }
        // find the sorted part and check the sorted part first. If sorted part contains the key. narrow down
        // otherwise go otherwise and find the sorted part.
        if (arr[start] <= arr[mid] && key <= arr[mid] && key >= arr[start]) {
            return binarySearch(arr, key, start, mid - 1);
        } else if (arr[mid] <= arr[end] && key >= arr[mid] && key <= arr[end]) {
            return binarySearch(arr, key, mid + 1, end);
        } else if (arr[end] <= arr[mid]) {
            return binarySearch(arr, key, mid + 1, end);
        } else if (arr[start] >= arr[mid]) {
            return binarySearch(arr, key, start, mid - 1);
        }

        return -1;
    }

    static int binarySearchRotated(int[] arr, int key) {
        return binarySearch(arr, key, 0, arr.length - 1 );
    }


    public static void main(String []args){
        int[] v1 = {6, 7, 1, 2, 3, 4, 5};
        System.out.println("Key(3) found at: " + binarySearchRotated(v1, 3));
        System.out.println("Key(6) found at: " + binarySearchRotated(v1, 6));

        int[] v2 = {4, 5, 6, 1, 2, 3};
        System.out.println("Key(3) found at: " + binarySearchRotated(v2, 3));
        System.out.println("Key(6) found at: " + binarySearchRotated(v2, 6));
    }
}