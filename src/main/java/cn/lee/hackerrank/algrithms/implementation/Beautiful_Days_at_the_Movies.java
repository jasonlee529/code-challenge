package cn.lee.hackerrank.algrithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
 * Lily likes to play games with integers and their reversals. For some integer , we define  to be the reversal of all digits in . For example, , , and .
 * <p>
 * Logan wants to go to the movies with Lily on some day  satisfying , but he knows she only goes to the movies on days she considers to be beautiful. Lily considers a day to be beautiful if the absolute value of the difference between  and  is evenly divisible by .
 * <p>
 * Given , , and , count and print the number of beautiful days when Logan and Lily can go to the movies.
 * <p>
 * Input Format
 * <p>
 * A single line of three space-separated integers describing the respective values of , , and .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print the number of beautiful days in the inclusive range between  and .
 * <p>
 * Sample Input
 * <p>
 * 20 23 6
 * Sample Output
 * <p>
 * 2
 * Explanation
 * <p>
 * Logan wants to go to the movies on days , , , and . We perform the following calculations to determine which days are beautiful:
 * <p>
 * Day  is beautiful because the following evaluates to a whole number:
 * Day  is not beautiful because the following doesn't evaluate to a whole number:
 * Day  is beautiful because the following evaluates to a whole number:
 * Day  is not beautiful because the following doesn't evaluate to a whole number:
 * Only two days,  and , in this interval are beautiful. Thus, we print  as our answer.
 * Created by jason on 18-2-10.
 */
public class Beautiful_Days_at_the_Movies {
    static int beautifulDays(int i, int j, int k) {
        // Complete this function
        int cnt = 0;
        for (int m = i; m <= j; m++) {
            int t = Math.abs(m - reverse(m));
            if (t % k == 0) {
                cnt++;
            }
        }
        return cnt;
    }

    static int reverse(int m) {
        String mStr = String.valueOf(m);
        char[] chars = new char[mStr.length()];
        for (int i = 0; i < mStr.length(); i++) {
            chars[i] = mStr.charAt(mStr.length() - i - 1);
        }
        return Integer.valueOf(new String(chars));

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int j = in.nextInt();
        int k = in.nextInt();
        int result = beautifulDays(i, j, k);
        System.out.println(result);
        in.close();
    }
}
