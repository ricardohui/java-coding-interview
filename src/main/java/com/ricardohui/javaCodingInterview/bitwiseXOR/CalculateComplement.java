package com.ricardohui.javaCodingInterview.bitwiseXOR;

import java.lang.Math;

class CalculateComplement {
    public static int bitwiseComplement(int n) {
        String binaryString = Integer.toBinaryString(n);
        int end = 0;
        StringBuilder sb = new StringBuilder();
        while (end < binaryString.length()) {
            if (binaryString.charAt(end)== '0') {
                sb.append('1');
            }else{
                sb.append('0');
            }
            end++;
        }
        String complementBinaryString = sb.toString();
        return Integer.parseInt(complementBinaryString, 2);
    }

    public static void main( String args[] ) {
        System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(8));
        System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(10));
    }
}