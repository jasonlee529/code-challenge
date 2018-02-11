package cn.lee.hackerrank.algrithms.implementation.Sherlock_and_Squares;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-squares/problem
 * Watson gives two integers ( and ) to Sherlock and asks if he can count the number of square integers between  and  (both inclusive).
 * <p>
 * Note: A square integer is an integer which is the square of any integer. For example, 1, 4, 9, and 16 are some of the square integers as they are squares of 1, 2, 3, and 4, respectively.
 * <p>
 * Input Format
 * <p>
 * The first line contains , the number of test cases.  test cases follow, each in a new line.
 * Each test case contains two space-separated integers denoting  and .
 * <p>
 * Constraints
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * For each test case, print the required answer in a new line.
 * <p>
 * Sample Input
 * <p>
 * 2
 * 3 9
 * 17 24
 * Sample Output
 * <p>
 * 2
 * 0
 * Explanation
 * <p>
 * Test Case #00: In range ,  and  are the two square numbers.
 * Test Case #01: In range , there are no square numbers.
 * Created by jason on 18-2-11.
 */
public class Solution {

    static int squares(int a, int b) {
        // Complete this function
        int cnt=0;
        double min = Math.sqrt(a);
        double max = Math.sqrt(b);
        for( int i=(int)Math.ceil(min);i<=max;i++){
            if(i*i>=a && i*i<=b){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int result = squares(a, b);
            System.out.println(result);
        }
        in.close();
    }

}
