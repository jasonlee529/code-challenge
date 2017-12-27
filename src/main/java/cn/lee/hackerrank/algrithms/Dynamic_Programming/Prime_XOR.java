package cn.lee.hackerrank.algrithms.Dynamic_Programming;

import java.util.Scanner;

import static java.util.stream.IntStream.range;

/**
 * https://www.hackerrank.com/challenges/prime-xor/problem
 * <pre>
 *
 *     Penny has an array of  integers, . She wants to find the number of unique multisets she can form using elements from the array such that the bitwise XOR of all the elements of the multiset is a prime number. Recall that a multiset is a set which can contain duplicate elements.
 *
 * Given  queries where each query consists of an array of integers, can you help Penny find and print the number of valid multisets for each array? As these values can be quite large, modulo each answer by  before printing it on a new line.
 *
 * Input Format
 *
 * The first line contains a single integer, , denoting the number of queries. The  subsequent lines describe each query in the following format:
 *
 * The first line contains a single integer, , denoting the number of integers in the array.
 * The second line contains  space-separated integers describing the respective values of .
 * Constraints
 *
 * Output Format
 *
 * On a new line for each query, print a single integer denoting the number of unique multisets Penny can construct using numbers from the array such that the bitwise XOR of all the multiset's elements is prime. As this value is quite large, your answer must be modulo .
 *
 * Sample Input
 *
 * 1
 * 3
 * 3511 3671 4153
 * Sample Output
 *
 * 4
 * Explanation
 *
 * The valid multisets are:
 *
 * is prime.
 * is prime.
 * is prime.
 * , which is prime.
 * Because there are four valid multisets, we print the value of  on a new line.
 * </pre>
 * Created by jason on 17-12-27.
 */
public class Prime_XOR {

    private static long MODULE = (long) Math.pow(10, 9) + 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int[][] qn = new int[q][];
        for (int i = 0; i < q; i++) {
            int n = sc.nextInt();
            int[] ar = new int[n];
            qn[i] = ar;
            for (int j = 0; j < n; j++) {
                ar[j] = sc.nextInt();
            }
        }
        for (int[] ar : qn) {
            int n = ar.length;
            int[] ars = range(0, n).map(t -> ar[n - t - 1]).distinct().toArray();
            long xog = 0;
            int cnt = 0;
            for (long a : ars) {
                if (isPrime(a)) {
                    xog = xor(xog, a);
                    cnt++;
                }
            }
            if (isPrime(xog)) {
                cnt++;
            }
            System.out.println(cnt % MODULE);
        }
    }

    private static long xor(long xog, long a) {
        return xog ^ a;
    }

    private static boolean isPrime(long n) {
        boolean isPrime = true;
        if (n < 2) {
            isPrime = false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
