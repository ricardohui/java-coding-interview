package com.ricardohui.javaCodingInterview.greedy;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

class FractionalKnapsack {
    public static double getMaxValue(double[] w, double[] v, double c) {
        // your awesome code goes here
        int totalItems = v.length;
        ItemValue[] itemValues = new ItemValue[totalItems];

        for (int i = 0; i < totalItems; i++) {
            itemValues[i] = new ItemValue(w[i], v[i], i);
        }

        Arrays.sort(itemValues, Comparator.<ItemValue>comparingDouble(i->i.cost).reversed());

        double totalValue = 0;
        for (ItemValue i: itemValues) {
            double currWeight = i.w;
            double currValue = i.v;

            if (currWeight <= c){
                c = c - currWeight;
                totalValue += currValue;
            }else{
                double fraction = c / currWeight;
                totalValue += (i.v * fraction);
                c = c - (i.w * fraction);
                break;
            }
        }
        return  totalValue;

    }


    public static void main(String[] args) {
        DecimalFormat decimal = new DecimalFormat("#.##"); // this class rounds off the double upto 2 decimal places

        double[] weights = {2, 1, 6, 0.5, 0.25, 7};
        double[] values = {50, 70, 100, 50, 30, 99};
        int capacity = 10;

        double maxValue = getMaxValue(weights, values, capacity);
        System.out.println("Maximum value we can obtain = " + decimal.format(maxValue));
    }
}


 class ItemValue // item value class
{
    Double cost;
    double w, v, i;

    public ItemValue(double weight, double value, int index) // constructor
    {
        w = weight;
        v = value;
        i = index;
        cost = new Double(v / w);
    }
}