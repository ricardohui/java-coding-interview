package com.ricardohui.javaCodingInterview.greedy;

class MinPlatforms {
    public static int findPlatform(int[] arrival, int[] departure) {
        int maxConcurrency = 0;

        if (arrival.length <= 1) {
            return arrival.length;
        }

        int earliestEvent = 0;
        int currentEvent = 1;
        int localConcurrency = 1;
        while (currentEvent < arrival.length && earliestEvent < arrival.length) {
            if (arrival[currentEvent] < departure[earliestEvent]){
                localConcurrency++;
                currentEvent++;

            }else if(earliestEvent < currentEvent && arrival[currentEvent] > departure[earliestEvent])  {
//                while (earliestEvent < currentEvent && arrival[currentEvent] > departure[earliestEvent]){
                    earliestEvent++;
                    localConcurrency--;
//                }
            }else{
                currentEvent++;
            }

            if (localConcurrency > maxConcurrency) {
                maxConcurrency = localConcurrency;
            }

        }

        return maxConcurrency;
    }
}


class KruskalMain{
    public static void main(String[] args){

        //Example 1
        int arrival[] = {900, 940, 950, 1100, 1500, 1800};
        int departure[] = {910, 1200, 1120, 1130, 1900, 2000};
        int answer  = MinPlatforms.findPlatform(arrival, departure);
        System.out.println("Minimum Number of Platforms Required for Plan1 = " + answer);


        System.out.println();

        // Example 2
        int arrival1[] = {200, 210, 300, 320, 350, 500};
        int departure1[] = {230, 240, 320, 430, 400, 520};
        int answer2 = MinPlatforms.findPlatform(arrival1, departure1);
        System.out.println("Minimum Number of Platforms Required for Plan2 = " + answer2);

    }
}