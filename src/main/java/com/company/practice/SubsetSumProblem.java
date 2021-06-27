package com.company.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSumProblem {
    public static void main(String[] args) {
        int[] arr = new int[]{2,2,3,7,8,10};
        System.out.println(checkSubSetSum(arr, 4));
        System.out.println(subSetSum(arr, 4));
    }

    private static List<Integer> subSetSum(int[] arr, int target) {
        List<Integer> res = new ArrayList<>();

        // same as Subset Sum
        boolean[][] opt = new boolean[arr.length][target + 1];
        for(int i = 0;i < arr.length; i++){
            for(int j = 0; j <= target; j++){
                if(j == 0)
                    opt[i][j] = true;
                else if(i == 0 && j == arr[i])
                    opt[i][j] = true;
                else if(i > 0){
                    if(j >= arr[i])
                        opt[i][j] = opt[i - 1][j] || opt[i-1][j - arr[i]];
                    else
                        opt[i][j] = opt[i - 1][j];
                }
            }
        }
        // check if subset sum exists
        //  return opt[arr.length - 1][target];

        // array that creates the subset sum
        int i = arr.length - 1, j = target;
        while (i > 0 && j > 0){
            while (i > 0 && opt[i - 1][j]) i--;
            res.add(arr[i]);
            j -= arr[i];
        }
        return res;
    }

    private static boolean checkSubSetSum(int[] arr, int target) {
        boolean[][] opt = new boolean[arr.length][target + 1];
        for(int i = 0;i < arr.length; i++){
            for(int j = 0; j <= target; j++){
                if(j == 0)
                    opt[i][j] = true;
                else if(i == 0 && j == arr[i])
                    opt[i][j] = true;
                else if(i > 0){
                    if(j >= arr[i])
                        opt[i][j] = opt[i - 1][j] || opt[i-1][j - arr[i]];
                    else
                        opt[i][j] = opt[i - 1][j];
                }
            }
        }
        return opt[arr.length - 1][target];

//        for(int i = 0; i <= target; i++)
//            System.out.print("\t " + i + "  ");
//        System.out.println();
//        for(int i = 0; i < opt.length; i++)
//            System.out.println(arr[i] + "\t" + Arrays.toString(opt[i]));
    }
}
