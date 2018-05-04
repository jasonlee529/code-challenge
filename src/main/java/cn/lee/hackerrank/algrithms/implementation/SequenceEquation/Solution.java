package cn.lee.hackerrank.algrithms.implementation.SequenceEquation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/permutation-equation/problem
 * <p>
 * You are given a sequence of  integers, . Each element in the sequence is distinct and satisfies . For each  where , find any integer  such that  and print the value of  on a new line.
 * <p>
 * For example, assume you have the sequence . For each value of  between  and  we analyze as follows:
 * <p>
 * , so
 * , so
 * , so
 * , so
 * , so
 * We find the values  for .
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer , the number of elements in the sequence.
 * The second line contains  space-separated integers  where .
 * <p>
 * Constraints
 * <p>
 * , where .
 * Each element in the sequence is distinct.
 * Output Format
 * <p>
 * For each  from  to , print an integer denoting any valid  satisfying the equation  on a new line.
 * <p>
 * Sample Input 0
 * <p>
 * 3
 * 2 3 1
 * Sample Output 0
 * <p>
 * 2
 * 3
 * 1
 * Explanation 0
 * <p>
 * Given the values of , , and , we calculate and print the following values for each  from  to :
 * <p>
 * , so we print the value of  on a new line.
 * , so we print the value of  on a new line.
 * , so we print the value of  on a new line.
 */
public class Solution {

    static int[] permutationEquation(int[] p) {
        // Complete this function
        int[] r = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            int pos = findPos(p, i + 1);
            pos = findPos(p, pos);
            r[i] = pos;
        }
        return r;
    }

    static int findPos(int[] p, int t) {
        for (int i = 0; i < p.length; i++) {
            if (p[i] == t) {
                return i + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n];
        for (int p_i = 0; p_i < n; p_i++) {
            p[p_i] = in.nextInt();
        }
        int[] result = permutationEquation(p);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
