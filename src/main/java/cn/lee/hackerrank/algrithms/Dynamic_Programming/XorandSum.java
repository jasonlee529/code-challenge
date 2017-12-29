package cn.lee.hackerrank.algrithms.Dynamic_Programming;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/xor-and-sum/problem
 * <pre>
 *     You are given two positive integers  and  in binary representation. You should find the following sum modulo :
 *
 * where operation  means exclusive OR operation, operation  means binary shift to the left.
 *
 * Please note, that we consider ideal model of binary integers. That is there is infinite number of bits in each number, and there are no disappearings (or cyclic shifts) of bits.
 *
 * Input Format
 *
 * The first line contains number   in binary representation. The second line contains number   in the same format. All the numbers do not contain leading zeros.
 *
 * Output Format
 *
 * Output a single integer  the required sum modulo .
 *
 * Sample Input
 *
 * 10
 * 1010
 * Sample Output
 *
 * 489429555
 * </pre>
 * Created by jason on 17-12-29.
 */
public class XorandSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long l = 0L;

        for (int i = 0; i <= 314159; i++) {
            l += a ^ (b << i);
        }
        System.out.println(l % (Math.pow(10, 9) + 7));
    }
}
