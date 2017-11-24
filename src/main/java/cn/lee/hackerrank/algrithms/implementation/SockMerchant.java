package cn.lee.hackerrank.algrithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <pre>
 *
 *     John works at a clothing store and he's going through a pile of socks to find the number of matching pairs. More specifically, he has a pile of  loose socks where each sock  is labeled with an integer, , denoting its color. He wants to sell as many socks as possible, but his customers will only buy them in matching pairs. Two socks,  and , are a single matching pair if they have the same color ().
 *
 * Given  and the color of each sock, how many pairs of socks can John sell?
 *
 * Input Format
 *
 * The first line contains an integer, , denoting the number of socks.
 * The second line contains  space-separated integers describing the respective values of .
 *
 * Constraints
 *
 * Output Format
 *
 * Print the total number of matching pairs of socks that John can sell.
 *
 * Sample Input
 *
 * 9
 * 10 20 20 10 10 30 50 10 20
 * Sample Output
 *
 * 3
 * Explanation
 *
 * sock.png
 *
 * As you can see from the figure above, we can match three pairs of socks. Thus, we print  on a new line.
 * </pre>
 * Created by jason on 17-11-23.
 */
public class SockMerchant {

    static int sockMerchant(int n, int[] ar) {
        // Complete this function
        int count = 0;
        Arrays.sort(ar);
        for (int i = 0; i < -1; i++) {
            if (ar[i] == ar[i + 1]) {
                count++;
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int ar_i = 0; ar_i < n; ar_i++) {
            ar[ar_i] = in.nextInt();
        }
        int result = sockMerchant(n, ar);
        System.out.println(result);
    }
}
