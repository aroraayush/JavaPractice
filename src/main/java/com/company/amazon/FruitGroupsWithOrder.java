package com.company.amazon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FruitGroupsWithOrder {

    /*codeList, a list of lists of strings representing the order and grouping of specific fruits that must be
    purchased in order to win the prize for the day.
    shoppingCart, a list of strings representing the order in which a customer purchases fruit

    Return an integer 1 if the customer is a winner else return

    •anything' in the codeList represents that any fruit can be ordered in place of
    •anything' in the group.
    •anything' has to be something, it cannot be "nothing."
    •anything' must represent one and only one fruit. If Secret code list is empty then it is assumed that the customer is a winner. E

    codeList = [['apple', "apple"], ['banana', "anything", "banana"]];
    shoppingCart = ['orange', 'apple', 'apple', 'banana', 'orange', 'banana']
    // Output 1

    codeList = [ ['orange'] ['apple', "apple"], ['banana', "orange", "apple"] ['banana']];
    shoppingCart = ['orange', 'apple', 'apple', 'banana', 'orange', 'apple', 'banana']
    // Output 1

    codeList = [ ['apple', "appricot"], ['banana', "anything", "guava"] ['papaya', 'anything]];
    shoppingCart = ['banana', 'orange', 'guava', 'apple', 'appricot', 'papaya', 'kiwi']
    //output 0*/

    public static void main(String[] args) {
        ArrayList<String> codeList = new ArrayList<>(Arrays.asList("apple apple","banana anything banana"));
        ArrayList<String> shoppingCart = new ArrayList<>(Arrays.asList("orange", "apple", "apple", "banana", "orange", "banana"));
        System.out.println(process(codeList, shoppingCart));
    }

    private static int process(List<String> codeList, List<String> cart) {
        // O(n * m * m) ~ O(n X m^2) | m will have to travel for all n values in the worst case (with outer loop for j)
        String[] cartArr = new String[cart.size()];
        int k = 0;
        for(String item : cart)
            cartArr[k++] = item;

        ArrayList<Integer> track = new ArrayList<>();
        int j = 0;
        int endIndex = 0;

        while (j < codeList.size()){
            String[] codeArr = codeList.get(j).split(" ");
            endIndex = getEndIndex(endIndex, codeArr, cartArr, track);
            if(track.size() == codeList.size()) return 1;
            j++;
        }
        return 0;
    }

    private static int getEndIndex(int startIdx, String[] codeArr, String[] cartArr, ArrayList<Integer> track) {
        for(int i = startIdx; i < cartArr.length; i++){
            int count = 0;
            for(int j = 0; j < codeArr.length; j++){
                if(i >= cartArr.length) return  startIdx;
                if(codeArr[j].equals(cartArr[i]) || codeArr[j].equals("anything")){
                    count++;
                    i++;
                }
                else{
                    count = 0;
                    break;
                }
                if(count == codeArr.length){
                    track.add(1);
                    return i;
                }
            }
        }
        return startIdx;
    }
}
