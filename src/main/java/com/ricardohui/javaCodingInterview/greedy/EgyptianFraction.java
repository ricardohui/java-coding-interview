package com.ricardohui.javaCodingInterview.greedy;
class Fraction
{
    public static void printEgyptianFraction(int numerator, int denominator)
    {
        //if either numerator or denominator is zero
        if (numerator == 0 || denominator == 0) {
            return;
        }
        //numerator divides denominator -> fraction in 1/n form
        if (denominator % numerator == 0) {
            System.out.print("1/" + denominator / numerator);
            return;
        }
        //denominator can divide numerator -> number not a fraction
        if (numerator % denominator == 0) {
            System.out.println(numerator / denominator);
            return;
        }
        //if numerator greater than denominator
        if (numerator > denominator) {
            System.out.println(numerator / denominator + " , ");
            printEgyptianFraction(numerator % denominator, denominator);
            return;
        }
        //denominator  greater than numerator here
        int n = denominator / numerator + 1;
        System.out.print("1/" + n + " , ");
        //call function recursively for remaining part
        printEgyptianFraction(numerator * n - denominator, denominator * n);
    }


}