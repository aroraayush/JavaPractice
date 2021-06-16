package com.company.haden;

// There are n people in a village (numbered from 1 to n). Some are friends are some are not; speciﬁcally, you are given
// m pairs of friends where each pair (x j , y j ) indicates that the two people x j and y j are friends (assume that
// x j != y j for all j ∈ [1, m]).
// Let f i be the number of friends that person i has (assume f i ∈ [1, n − 1]; that is, everyone has at least one friend).

// People in this village exchange gifts, following some peculiar rules. Speciﬁcally, between each pair of friends
// (say, x j and y j ), one of them would be a gift-giver and the other would be a gift-receiver.

// Hence, either x j gives to y j or y j gives to x j .
// For each person i, let g i be the number of gifts person i gives and r i the number of gifts person i receives
// (note that g i + r i = f i , then). The main constraint is that | g i − r i | ≤ 1 must be true for all
// i ∈ [1, n].

// Exmaple in main method below.
// We want to know whether we can choose who gives a gift to whom (for each pair of friends) such that
// for all i, | g i − r i | ≤ 1 would be satisfied.

// Design an algorithm that would ﬁnd such assignment.
// Note that a trivial solution is to check 2^m possibilities (because for each friend pair we can have
// x i giving a gift to y i or vice versa), but we want to design a polynomial time algorithm.

import java.util.Arrays;

public class Gifts {
    public static void main(String[] args) {
        // 10 people
        int[] arr = new int[10];
        int i = 0;
        while (i < 10)
            arr[i++] = i;
        System.out.println(Arrays.toString(arr));
        // m pairs like [1,2] [3,4] [5,6] [7,8] [9,10]
        // [1,3] [1,4]
        // [2,5] [2,7]
        // group 1, group 2, group 3

        // For instance, suppose n = 4, m = 5 with { (1, 2), (1, 4), (2, 4), (2, 3), (3, 4) } as (x i , y i )’s.

        int[][] edges = new int[][]{{1, 2}, {1, 4}, {2, 4}, {2, 3}, {3, 4}};
        // Note that
        // f(1) = 2 i.e. 2 friends for 1 (person 2 and person 4),
        // f(2) = 3,
        // f(3) = 2, and
        // f(4) = 3.

        // gift-giver and gift-receiver [Directed Edge]
        // g i be the number of gifts person i gives [No of output edges going out from node].
        // r i be the number of gifts person i receives.
        // g i + r i = f i [node's incoming + outgoing edges = no of friends for the node]
        // | g i − r i | ≤ 1            i.e.        | g i − r i | = 0 or 1

        //    2 <--  1
        //    | \   /\
        //    |  \  |
        //   \/   \ |
        //    3 -> 4

        // If person 1 gives a gift to person 2 (who receives one from person 1, then), person 2 gives a gift to
        // person 3, person 3 gives to person 4, and person 4 gives to person 1, then regardless of whether person
        // 2 gives a gift to person 4 or vice versa, the constraints would be satisﬁed.

        // On the other hand, if person 1 gives a gift to person 2 as well as to person 4, then no matter what others
        // do, the constraints would not be satisﬁed (because person 1 would give two gifts but receive no gifts).

        // Note that each pair of friends, one person must give a gift and the other person must receive a gift.
        // Therefore, given m, total 'm' gifts must change hands. [5 edges]
    }
}
