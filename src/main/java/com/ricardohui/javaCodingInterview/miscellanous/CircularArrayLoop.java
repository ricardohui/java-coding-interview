class CircularArrayLoop {

    public static boolean loopExists(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isForward = arr[i] > 0;
            int fast = i;
            int slow = i;

            do {
                fast = findNextIndex(arr, isForward, fast);
                slow = findNextIndex(arr, isForward, slow);

                if (fast != -1) {
                    fast = findNextIndex(arr, isForward, fast);
                }
            } while (fast != -1 && slow != -1 && fast != slow);

            if (slow != -1 && slow == fast) {
                return true;
            }

        }
        return false;
    }

    private static int findNextIndex(int[] arr, boolean isForward, int currentIndex) {
        boolean direction = arr[currentIndex] >= 0;

        if (direction != isForward) {
            return -1;
        }

        int nextIndex = (currentIndex + arr[currentIndex]) % arr.length;

        if (nextIndex < 0) {
            nextIndex += arr.length;
        }

        // miss one element cycle which does not count as cycle


        return nextIndex;
    }

    public static void main(String[] args) {
        System.out.println(CircularArrayLoop.loopExists(new int[] { 1, 2, -1, 2, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 2, -1, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 1, -1, -2 }));
    }
}
