package com.company.binarySearch;

public class BinarySearch {

    public static void main(String[] args) {

    }

    private static int binarySearchIteration(int[] arr, int target, int low, int high) {
        if(target > arr[high])
            return -1;

        while (low<=high){
            if(low == high && arr[low] != target){
                return low;
            }
            int mid = low + (high - low)/2;
            if(arr[mid] == target)
                return mid;
            if(target < arr[mid]){
                high = mid -1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
