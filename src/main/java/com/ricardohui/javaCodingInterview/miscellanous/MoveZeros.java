import java.util.Arrays;

class MoveZeros {
    static void moveZerosToLeft(int[] A) {
        int readerIndex = A.length - 1, writerIndex = A.length - 1, countZero = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                countZero++;
            }
        }

        if (countZero > 0) {
            while (writerIndex >= countZero) {
                while (readerIndex > 0 && A[readerIndex] == 0) {
                    readerIndex--;
                }
                System.out.println("readerIndex: " + readerIndex);
                A[writerIndex] = A[readerIndex];
                readerIndex--;
                writerIndex--;
            }
            for (int i = 0; i < countZero; i++) {
                A[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] v = new int[]{1, 10, 20, 0, 59, 63, 0, 88, 0};
        System.out.println("Original Array: " + Arrays.toString(v));

        moveZerosToLeft(v);

        System.out.println("After Moving Zeroes to Left: " + Arrays.toString(v));
    }
}