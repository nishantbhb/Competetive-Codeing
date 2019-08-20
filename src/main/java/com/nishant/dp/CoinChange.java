package com.nishant.dp;

class CoinChange {

    private static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        dp[0] = 1; //base case

        for (int coin : coins) {
            int currAmount = 1;
            while (currAmount <= amount) {
                if (currAmount >= coin)
                    dp[currAmount] += dp[currAmount - coin];
                currAmount++;
            }
        }
        return dp[amount];

    }


    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1, 2, 5}));
    }


}


