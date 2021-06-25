package com.company.practice;

import java.util.HashSet;

public class CoinGroupings {
    // You have a collection of coins, and you know the values of the coins and the quantity of each type of coin in it.
    // You want to know how many distinct sums you can make from non-empty groupings of these coins.

    public static void main(String[] args) {
        System.out.println(possibleSums(new int[]{10, 50, 100},new int[]{1, 2, 1}));
    }

    static int possibleSums(int[] coins, int[] quantity) {
        HashSet<Integer> sumSet = new HashSet<>();
        sumSet.add(0);
        for(int i = 0; i < quantity.length; i++){
            HashSet<Integer> set = new HashSet<>(sumSet);
            for(Integer sum : sumSet){
                int qty = quantity[i];
                while(quantity[i] > 0){
                    set.add(sum + (quantity[i] * coins[i]));
                    quantity[i]--;
                }
                quantity[i] = qty;
            }
            sumSet.addAll(set);
        }
        return sumSet.size() - 1;
    }
}
