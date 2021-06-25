package com.company.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* An Amazon Customer wants to buy a pair of jeans, a pair of shoes, a skirt, and a top
* but has a limited budget in dollars.
* Given different pricing options for each product, determine how many options
* our customer has to buy 1 of each product.
*
* You can not spend more money than the budgeted amount.
*
* priceOfJean = [2,3]
* priceOfShoes = [4]
* priceOfSkirts = [2,3]
* priceofTops = [1,2]
* budget = 10
* */
public class ShoppingOptions {

    public static void main(String[] args) {
        List<Integer> priceOfJeans = new ArrayList<>(Arrays.asList(2, 3));
        List<Integer> priceOfShoes = new ArrayList<>(Collections.singletonList(4));
        List<Integer> priceOfSkirts = new ArrayList<>(Arrays.asList(2, 3));
        List<Integer> priceOfTops = new ArrayList<>(Arrays.asList(1, 2));
        int dollars = 10;
        System.out.println(getNumberOfOptions(priceOfJeans, priceOfShoes, priceOfSkirts, priceOfTops, dollars));
    }

    public static long getNumberOfOptions(List<Integer> priceOfJeans, List<Integer> priceOfShoes,
                                          List<Integer> priceOfSkirts, List<Integer> priceOfTops, int budget)
    {

        return 0 ;
    }
}
