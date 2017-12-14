package cn.lee.hackerrank.algrithms.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/kaprekar-numbers/problem
 * <pre>
 *     A modified Kaprekar number is a positive whole number  with  digits, such that when we split its square into two pieces - a right hand piece  with  digits and a left hand piece  that contains the remaining  or digits, the sum of the pieces is equal to the original number (i.e.  +  = ).
 *
 * Note: r may have leading zeros.
 *
 * Here's an explanation from Wikipedia about the ORIGINAL Kaprekar Number (spot the difference!): In mathematics, a Kaprekar number for a given base is a non-negative integer, the representation of whose square in that base can be split into two parts that add up to the original number again. For instance, 45 is a Kaprekar number, because 45² = 2025 and 20+25 = 45.
 *
 * The Task
 * You are given the two positive integers  and , where  is lower than . Write a program to determine how many Kaprekar numbers are there in the range between  and  (both inclusive) and display them all.
 *
 * Input Format
 *
 * There will be two lines of input: , lowest value , highest value
 *
 * Constraints:
 *
 * Output Format
 *
 * Output each Kaprekar number in the given range, space-separated on a single line. If no Kaprekar numbers exist in the given range, print INVALID RANGE.
 *
 * Sample Input
 *
 * 1
 * 100
 * Sample Output
 *
 * 1 9 45 55 99
 *
 * Explanation
 *
 * , , , , and  are the Kaprekar Numbers in the given range.
 * </pre>
 * Created by jason on 17-12-14.
 */
public class ModifiedKaprekarNumbers {

    public static void main(String[] args) {
        kaprekar(77778, 99999);
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        List<Integer> r = kaprekar(p, q);
    }

    private static List<Integer> kaprekar(int p, int q) {
        List<Integer> r = new ArrayList<Integer>();
        for (int i = p; i <= q; i++) {
            if (isKaprekar(i)) {
                r.add(i);
            }
        }
        if (r.size() > 0) {
            for (int i : r) {
                System.out.print(i + " ");
            }
        } else {
            System.out.println("INVALID RANGE");
        }
        return r;

    }

    private static boolean isKaprekar(int n) {
        long sq = (long)n * n;
        char[] s = String.valueOf(sq).toCharArray();
        if (s.length == 1) {
            return sq == n;
        }
        int d = s.length % 2 == 0 ? s.length / 2 : s.length / 2 + 1;
        char[] ls = new char[s.length - d];
        char[] rs = new char[d];
        System.arraycopy(s, 0, ls, 0, s.length - d);
        System.arraycopy(s, s.length -d, rs, 0, d);
        int l = Integer.valueOf(new String(ls));
        int r = Integer.valueOf(new String(rs));
        if (l + r == n) {
            return true;
        }
        return false;
    }

}
