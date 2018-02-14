package cn.lee.hackerrank.algrithms.implementation.Save_the_Prisoner;

/**
 * https://www.hackerrank.com/challenges/save-the-prisoner/problem
 * <p>
 * A jail has  prisoners, and each prisoner has a unique id number, , ranging from  to . There are  sweets that must be distributed to the prisoners.
 * <p>
 * The jailer decides the fairest way to do this is by sitting the prisoners down in a circle (ordered by ascending ), and then, starting with some random , distribute one candy at a time to each sequentially numbered prisoner until all  candies are distributed. For example, if the jailer picks prisoner , then his distribution order would be  until all  sweets are distributed.
 * <p>
 * But wait—there's a catch—the very last sweet is poisoned! Can you find and print the ID number of the last prisoner to receive a sweet so he can be warned?
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer, , denoting the number of test cases.
 * The  subsequent lines each contain  space-separated integers:
 * (the number of prisoners),  (the number of sweets), and  (the prisoner ID), respectively.
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * For each test case, print the ID number of the prisoner who receives the poisoned sweet on a new line.
 * <p>
 * Sample Input 0
 * <p>
 * 2
 * 5 2 1
 * 5 2 2
 * Sample Output 0
 * <p>
 * 2
 * 3
 * Explanation 0
 * <p>
 * In first query, there are  prisoners and  sweets. Distribution starts at ID number , so prisoner  gets the first sweet and prisoner  gets the second (last) sweet. Thus, we must warn prisoner  about the poison, so we print  on a new line.
 * Created by jason on 18-2-14.
 */

import java.util.Scanner;

public class Solution {

    static int saveThePrisoner(int n, int m, int s) {
        // Complete this function
        int t = (s + m - 1) % n + 1;
        return t;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int s = in.nextInt();
            int result = saveThePrisoner(n, m, s);
            System.out.println(result);
        }
    }
}

