package cn.lee.hackerrank.algrithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/cats-and-a-mouse/problem
 * <pre>
 *     Two cats named  and  are standing at integral points on the x-axis. Cat  is standing at point  and cat  is standing at point . Both cats run at the same speed, and they want to catch a mouse named  that's hiding at integral point  on the x-axis. Can you determine who will catch the mouse?
 *
 * You are given  queries in the form of , , and . For each query, print the appropriate answer on a new line:
 *
 * If cat  catches the mouse first, print Cat A.
 * If cat  catches the mouse first, print Cat B.
 * If both cats reach the mouse at the same time, print Mouse C as the two cats fight and mouse escapes.
 * Input Format
 *
 * The first line contains a single integer, , denoting the number of queries.
 * Each of the  subsequent lines contains three space-separated integers describing the respective values of  (cat 's location),  (cat 's location), and  (mouse 's location).
 *
 * Constraints
 *
 * Output Format
 *
 * On a new line for each query, print Cat A if cat  catches the mouse first, Cat B if cat  catches the mouse first, or Mouse C if the mouse escapes.
 *
 * Sample Input 0
 *
 * 3
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * Sample Output 0
 *
 * Cat B
 * Mouse C
 * Cat A
 * Explanation 0
 *
 * Query 0: The positions of the cats and mouse are shown below: image
 *
 * Cat  will catch the mouse first, so we print Cat B on a new line.
 *
 * Query 1: In this query, cats  and  reach mouse  at the exact same time: image
 *
 * Because the mouse escapes, we print Mouse C on a new line.
 * </pre>
 * Created by jason on 17-12-6.
 */
public class CatsandaMouse {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            cat(x, y, z);
        }
    }

    static void cat(int x, int y, int z) {
        int zx = Math.abs(z - x);
        int zy = Math.abs(z - y);
        if ((zx - zy) > 0) {
            System.out.println("Cat B");
        } else if ((zx - zy) < 0) {
            System.out.println("Cat A");
        } else {
            System.out.println("Mouse C");
        }
    }

}
