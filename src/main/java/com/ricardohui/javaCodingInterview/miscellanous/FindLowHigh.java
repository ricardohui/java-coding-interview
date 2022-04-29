import java.util.Arrays;
import java.util.List;

class FindLowHigh{
    static int findLowIndex (List<Integer> arr, int key) {
        if (arr.isEmpty()) return -1;

        int start = 0;
        int mid = arr.size() / 2;
        int end = arr.size() - 1;

        while (start <= end) {

            if (key > arr.get(mid)) {
                start = mid + 1;
            } else {
                end = mid-1;
            }
            mid = start + ((end - start) / 2);
        }

        if (arr.get(start) == key) {
            return start;
        }
      return -1;
    }

    static int findHighIndex(List<Integer> arr, int key) {
        if (arr.isEmpty()) return -1;

        int start = 0;
        int mid = arr.size() / 2;
        int end = arr.size() - 1;

        while (start <= end) {
            if (key >= arr.get(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            mid = start + ((end - start) / 2);
        }

        if (end == -1){
            return end;
        }
        if (arr.get(end) == key) {
            return end;
        }

        return -1;

    }
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6);
        int key = 5;
        int low = findLowIndex(array, key);
        int high = findHighIndex(array, key);
//        assert low == 16 : "low is wrong";
//        assert high == 17 :"high is wrong actual: "+high;

        System.out.println("Low Index of " + key + ": " + low);
        System.out.println("High Index of " + key + ": " + high);

        key = -2;
        low = findLowIndex(array, key);
        high = findHighIndex(array, key);
        assert low == -1 : "low is wrong";
        assert high == -1 : "high is wrong actual: "+high;

        System.out.println("Low Index of " + key + ": " + low);
        System.out.println("High Index of " + key + ": " + high);


    }
}