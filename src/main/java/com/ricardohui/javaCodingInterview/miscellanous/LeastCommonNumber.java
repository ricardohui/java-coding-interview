
import java.util.ArrayList;
import java.util.Arrays;


class LeastCommonNumber{
    static Integer findLeastCommonNumber(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0, j = 0, k = 0;

        while ( i < arr1.length && j < arr2.length && k < arr3.length) {
            int num1 = arr1[i];
            int num2 = arr2[j];
            int num3 = arr3[k];

            if (num1 == num2 && num2 == num3) {
                return num1;
            }

            if (num1 <= num2 && num1 <= num3) {
                i++;
            } else if (num2 <= num1 && num2 <= num3) {
                j++;
            } else {
                // num3 is smallest
                k++;
            }
        }

        return -1;
    }
    public static void main(String []args){
        int[] v1 = new int[]{6, 7, 10, 25, 30, 63, 64};
        int[] v2 = new int[]{0, 4, 5, 6, 7, 8, 50};
        int[] v3 = new int[]{1, 6, 10, 14};
        Integer result = findLeastCommonNumber(v1, v2, v3);
        if (result == 6) {
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
        System.out.println("Least Common Number: " + result);
    }
}