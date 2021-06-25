package com.company.practice;

import java.util.Arrays;

public class SubarraysOfAnArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
                printSubArray(arr, i, j);
            }
        }
    }

    private static void printSubArray(int[] arr, int low, int high) {
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, low, high + 1)));
    }
}
