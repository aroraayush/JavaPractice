package com.company.binarySearch;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,1,2,3,3,4,4};
        int[] arr2 = new int[]{1,1,2,2,3,4,4};
        int[] arr3 = new int[]{1,2,2,3,3,4,4};
        System.out.println(singleElemInSortedArr(arr1));
    }

    private static int singleElemInSortedArr(int[] arr) {
        if(arr.length == 1)
            return arr[0];
        return singleElemInSortedArr(arr, 0, arr.length - 1);
    }

    private static int singleElemInSortedArr(int[] arr, int low, int high) {

        // Boundary Checks
        if(arr[low] != arr[low + 1])
            return arr[low];
        if(arr[high] != arr[high - 1])
            return arr[high];

        while (low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1])
                return arr[mid];


            // partition
            // After the unique element the number will start from odd idx
            // 1 1 2 3 3 4 4
            // 0 1 2 3 4 5 6
            if((mid % 2 != 0 && arr[mid] == arr[mid - 1]) ||
                    (mid % 2 == 0 && arr[mid] == arr[mid + 1] ))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
