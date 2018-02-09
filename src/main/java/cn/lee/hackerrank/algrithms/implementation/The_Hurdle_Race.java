package cn.lee.hackerrank.algrithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-hurdle-race/problem
 * Dan is playing a video game in which his character competes in a hurdle race by jumping over  hurdles with heights . He can initially jump a maximum height of  units, but he has an unlimited supply of magic beverages that help him jump higher! Dan can drink any number magic beverages and the maximum height he can jump during the entire race increases by the number of magic beverages he drink.
 * <p>
 * Given , , and the heights of all the hurdles, find and print the minimum number of magic beverages Dan must drink to complete the race.
 * <p>
 * Input Format
 * <p>
 * The first line contains two space-separated integers describing the respective values of  (the number of hurdles) and  (the maximum height he can jump without consuming any beverages).
 * The second line contains  space-separated integers describing the respective values of .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print an integer denoting the minimum number of magic beverages Dan must drink to complete the hurdle race.
 * <p>
 * Sample Input 0
 * <p>
 * 5 4
 * 1 6 3 5 2
 * Sample Output 0
 * <p>
 * 2
 * Explanation 0
 * <p>
 * Dan's character can jump a maximum of  units, but the tallest hurdle has a height of :
 * <p>
 * image
 * <p>
 * To be able to jump all the hurdles, Dan must drink  magic beverages.
 * <p>
 * Sample Input 1
 * <p>
 * 5 7
 * 2 5 4 5 2
 * Sample Output 1
 * <p>
 * 0
 * Explanation 1
 * <p>
 * Dan's character can jump a maximum of  units, which is enough to cross all the hurdles:
 * <p>
 * image
 * <p>
 * Because he can already jump all the hurdles, Dan needs to drink  magic beverages.
 * Created by jason on 18-2-9.
 */
public class The_Hurdle_Race {
    static int hurdleRace(int k, int[] height) {
        // Complete this function
        int max = height[0];
        for (int i : height) {
            max = max > i ? max : i;
        }

        return max - k < 0 ? 0 : max - k;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] height = new int[n];
        for (int height_i = 0; height_i < n; height_i++) {
            height[height_i] = in.nextInt();
        }
        int result = hurdleRace(k, height);
        System.out.println(result);
        in.close();
    }

}
