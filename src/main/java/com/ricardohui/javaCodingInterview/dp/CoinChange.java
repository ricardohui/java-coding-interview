package com.ricardohui.javaCodingInterview.dp;
import java.util.*;

 class CoinChange{
   public static int coinChange(int [] coins, int total) {
      int[] counter = new int[total + 1];
      Arrays.fill(counter, -1);
     // bottom up 
      // initialization
    counter[0] = 0;

      for (int target = 1; target <= total; target++) {
        for (int coin: coins){
          if (coin == target) counter[target] = 1;

          if (target > coin && counter[target-coin] >= 0) {
            counter[target] = Math.min(target, 1 + counter[target-coin]);
            
          }
        }
      }
      
      return counter[total];
   }

   
   public static void main(String[] args) {
    int[] coins = {1, 2, 5};
    int amount = 11;
    int result = coinChange(coins, amount);
    System.out.println("Minimum number of coins needed for 11: " + result);

    amount = 0;
    result = coinChange(coins, amount);
    System.out.println("Minimum number of coins needed for 0: " + result);

    coins = new int[1];
    coins[0] = 5;
    amount = 3;
    result = coinChange(coins, amount);
    System.out.println("Minimum number of coins needed for 3: "+ result);



}
}