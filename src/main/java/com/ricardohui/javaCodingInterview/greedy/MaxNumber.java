package com.ricardohui.javaCodingInterview.greedy;

public class MaxNumber {
    public static void findLargestNumber(int number_of_digits, int sum_of_digits ) {
        int i = 0;
        int remainingSum = sum_of_digits;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < number_of_digits) {
            if (remainingSum / 9 >= 1){
                stringBuilder.append(9);
                remainingSum -= 9;
            }else{
                int remainingDigit = remainingSum % 9;
                stringBuilder.append(remainingDigit);
                break;
            }
            i++;
        }
        while (stringBuilder.length() != number_of_digits){
            stringBuilder.append(0);
        }
        if (sum_of_digits!=(reduceToSum(stringBuilder))) {
            System.out.println("None");
        }else{
            System.out.println(stringBuilder);

        }
        System.out.print("\n");
    }

    static int reduceToSum(StringBuilder stringBuilder){
        int sum = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            sum += new Integer( stringBuilder.subSequence(i, i+1).toString());
            System.out.println(sum);
        }
        System.out.println("sum = " + sum);
        return sum;

    }

    public static void main(String[] args) {
        int sumOfDigits = 20;
        int numberOfDigits = 3;

        System.out.println("If sum of digits is 20 and number of digits is 3 then ");
        MaxNumber.findLargestNumber(numberOfDigits, sumOfDigits);
        System.out.println();

        //Example 2
        sumOfDigits = 100;
        numberOfDigits = 2;

        System.out.println("If sum of digits is 100 and number of digits is 2 then ");
        MaxNumber.findLargestNumber(numberOfDigits, sumOfDigits);

    }
}
