package com.company.haden;

// Consider strings that consist of lower English alphabets (‘a’ through ‘z’). We define nice strings as follows:
// • Empty string (of length 0) is a nice string.
// • If X is a nice string, then nXi is also a nice string (which is two characters longer than X).
// • If X is a nice string, then cXe is also a nice string (which is two characters longer than X).
// • If X and Y are nice strings, then XY and Y X (concatenations) are also nice strings.
// Here are some nice strings: ni, ce, nice, ceni, and cnie.
// Here are some that are not: in, ec, niec, and nicce.
// Given a string X of length n, ﬁnd a way to turn it into a nice string by removing fewest number of characters. You may remove any character(s) that appear in X, but you want to minimize the total number of characters you remove. If X is a nice string in the ﬁrst place, then you would not remove any characters. Design a polynomial time algorithm that solves this problem.

public class NiceStrings {
    public static void main(String[] args) {
        String str = "ni";
//        String str = "ce";

        String niceStr = makeStringNice(str);
        System.out.println("niceStr = " + niceStr);
    }

    private static String makeStringNice(String str) {
        if(str.length() == 0) return str;

        return str;

    }
}
