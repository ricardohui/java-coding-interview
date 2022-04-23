package com.ricardohui.javaCodingInterview.greedy;

import java.util.HashMap;

class MaxThief {
    public static int policeThief(char[] policeThiefArray, int n, int k) {
        int result = 0;
        HashMap<Integer, Integer> range = new HashMap<>();

        for (int i = 0; i < policeThiefArray.length; i++) {
            range.putIfAbsent(i,0);
            if (policeThiefArray[i]=='P'){

                for (int j = 1; j <= k && i-j > 0 ; j++) {
                    range.put(i-j, range.getOrDefault(i-j, 0)+1);
                }


                for (int j = 1; j <= k && i+j < policeThiefArray.length; j++) {
                    range.put(i + j, range.getOrDefault(i + j, 0) + 1);
                }
            }
        }

        for (int i = 0; i < policeThiefArray.length; i++) {
            if (policeThiefArray[i] == 'T' && range.get(i) > 0) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int k, n;

        char policeTheifArray[] = {'P', 'T', 'T', 'P', 'T'};
        k = 2;
        n = policeTheifArray.length;
        System.out.println("Maximum thieves caught for {P, T, T, P, T}: " + MaxThief.policeThief(policeTheifArray, n, k));

        char policeTheifArray1[] = {'T', 'T', 'P', 'P', 'T', 'P'};
        k = 2;
        n = policeTheifArray1.length;
        System.out.println("Maximum thieves caught for {T, T, P, P, T,P}: " + MaxThief.policeThief(policeTheifArray1, n, k));

    }
}
