package com.ricardohui.javaCodingInterview.bitwiseXOR;

class SingleNumber {
    public static int findSingleNumber(int[] arr) {
        int x = 0;

        for (int num: arr) {
            x = x ^ num;
        }
        return x;
    }

    public static void main( String args[] ) {
        System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
    }
}