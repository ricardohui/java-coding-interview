package com.ricardohui.javaCodingInterview.bitwiseXOR;

public class FlipAndInvertImage {

    private static void swap(int[][] arr, int row, int col1, int col2){
        int temp = arr[row][col1];
        arr[row][col1] = arr[row][col2];
        arr[row][col2] = temp;
    }
    public static int[][] flipAndInvertImage(int[][] arr) {
        int rowSize = arr.length;
        int colSize = arr[0].length;
        // reversing order
        int i = 0;
        int j = 0;
        while (i < rowSize){
            while (j < colSize / 2) {
                swap(arr, i, j, colSize - j - 1);
                j++;
            }
            i++;
        }
        for(i=0; i < arr.length; i++) {
            for (j=0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // invert by XOR with 000

        return arr;
    }

    public static void print(int[][] arr) {
        for(int i=0; i < arr.length; i++) {
            for (int j=0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 1}, {1, 1, 1}, {0, 1, 1}};
        print(flipAndInvertImage(arr));

        int[][]arr2 = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        print(flipAndInvertImage(arr2));
    }
}