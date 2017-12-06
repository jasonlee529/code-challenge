package cn.lee.hackerrank.algrithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/magic-square-forming/problem
 * <pre>
 *
 *     We define a magic square to be an  matrix of distinct positive integers from  to  where the sum of any row, column, or diagonal (of length ) is always equal to the same number (i.e., the magic constant).
 *
 * Consider a  matrix, , of integers in the inclusive range . We can convert any digit, , to any other digit, , in the range  at cost .
 *
 * Given , convert it into a magic square at minimal cost by changing zero or more of its digits. Then print this cost on a new line.
 *
 * Note: The resulting magic square must contain distinct integers in the inclusive range .
 *
 * Input Format
 *
 * There are  lines of input. Each line describes a row of the matrix in the form of  space-separated integers denoting the respective first, second, and third elements of that row.
 *
 * Constraints
 *
 * All integers in  are in the inclusive range .
 * Output Format
 *
 * Print an integer denoting the minimum cost of turning matrix  into a magic square.
 *
 * Sample Input 0
 *
 * 4 9 2
 * 3 5 7
 * 8 1 5
 * Sample Output 0
 *
 * 1
 * Explanation 0
 *
 * Matrix  initially looks like this:
 *
 * 4 9 2
 * 3 5 7
 * 8 1 5
 * Observe that it's not yet magic, because not all rows, columns, and center diagonals sum to the same number.
 *
 * If we change the bottom right value, , from  to  at a cost of ,  becomes a magic square at the minimum possible cost. Thus, we print the cost, , on a new line.
 *
 * Sample Input 1
 *
 * 4 8 2
 * 4 5 7
 * 6 1 6
 * Sample Output 1
 *
 * 4
 * Explanation 1
 *
 * Considering 0 - based indexing if we make -> at a cost of :  , -> at a cost of : and -> at a cost of :  , then net cost will be (  ).
 * </pre>
 * Created by jason on 17-12-6.
 */
public class FormingaMagicSquare {
    public static void main(String[] args) {
        format(new int[][]{{4, 5, 8}, {2, 4, 1}, {1, 9, 7}});
        Scanner in = new Scanner(System.in);
        int[][] s = new int[3][3];
        for (int s_i = 0; s_i < 3; s_i++) {
            for (int s_j = 0; s_j < 3; s_j++) {
                s[s_i][s_j] = in.nextInt();
            }
        }
        format(s);
        //  Print the minimum cost of converting 's' into a magic square
    }

    private static void format(int[][] s) {
        int[][][] pos = new int[][][]{
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
        };
        int result = 100;
        for (int k = 0; k < pos.length; k++) {
            int[][] src = pos[k];
            int t = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    t += Math.abs(src[i][j] - s[i][j]);
                }
            }
            result = result <= t ? result : t;
        }
        System.out.println(result);
    }
}
