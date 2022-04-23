package com.ricardohui.javaCodingInterview.greedy;

import java.util.ArrayList;

class ChangeMachine
{
    // a public collection of available coins
    public static int [] coins = {25, 10, 5, 1};

    public static ArrayList<Integer> getMinCoins(int amount)  // function to recieve change in the form of coins
    {
        // given the coins are sorted
        int remainingAmount = amount;
        ArrayList<Integer> change = new ArrayList<Integer>();
        for (int i = 0; i < coins.length; i++) {
            while (coins[i] <= remainingAmount){
                remainingAmount -= coins[i];
                change.add(coins[i]);
            }
        }

        return change;
    }

    public static void main(String args[])
    {
        // Play around with this amount to see how many coins you get!
        int amount = 1;
        System.out.println(amount + " --> " + getMinCoins(amount));

        amount = 17;
        System.out.println(amount + " --> " + getMinCoins(amount));

        amount = 33;
        System.out.println(amount + " --> " + getMinCoins(amount));

        amount = 99;
        System.out.println(amount + " --> " + getMinCoins(amount));
    }
}