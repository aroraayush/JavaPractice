package com.company.practice;

import java.util.Arrays;

public class MinCost2DArrNoRepetition {

    public static void main(String[] args) {
        int n = 5, m = 4;
        int arr[][] = {
                {4, 5, 3, 2},
                {6, 2, 8, 1},
                {6, 2, 2, 1},
                {4, 5, 5, 1},
                {1, 2, 3, 4}
        };

        System.out.println(minCost2DArrNoRepetition(arr));
    }

    private static int minCost2DArrNoRepetition(int[][] arr) {
        if(arr == null || arr.length == 0) return 0;

        int opt[][] = new int[arr.length][arr[0].length];

        int min = Integer.MAX_VALUE;
        for(int j = 0; j < arr[0].length; j++)
            opt[0][j] = arr[0][j];

        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                min = Integer.MAX_VALUE;
                for(int k = 0; k < arr[0].length; k++){
                    if(k != j){
                        min = Math.min(min, opt[i-1][k]);
                    }
                }
                opt[i][j] = min + arr[i][j];
            }
        }
        
        for(int j = 0; j < arr[0].length - 1; j++){
            min = Math.min(min, opt[arr.length - 1][j]);
        }
        return min;
    }
}
