package cn.lee.hackerrank.algrithms.implementation.Extra_Long_Factorials;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/extra-long-factorials/problem
 * You are given an integer . Print the factorial of this number.
 * <p>
 * Input
 * Input consists of a single integer , where .
 * <p>
 * Output
 * Print the factorial of .
 * <p>
 * Example
 * For an input of , you would print .
 * <p>
 * Note: Factorials of  can't be stored even in a  long long variable. Big integers must be used for such calculations. Languages like Java, Python, Ruby etc. can handle big integers, but we need to write additional code in C/C++ to handle huge values.
 * <p>
 * We recommend solving this challenge using BigIntegers.
 * Created by jason on 18-2-10.
 */
public class Solution {
    static void extraLongFactorials(int n) {
        // Complete this function
        BigInteger bi = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            bi = bi.multiply(BigInteger.valueOf(i));
        }
        System.out.println(bi.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        extraLongFactorials(n);
        in.close();
    }
}
