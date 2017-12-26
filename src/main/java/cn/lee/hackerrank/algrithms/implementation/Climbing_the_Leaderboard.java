package cn.lee.hackerrank.algrithms.implementation;

import java.util.Scanner;

import static java.util.Arrays.binarySearch;
import static java.util.stream.IntStream.range;

/**
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 * <pre>
 * Alice is playing an arcade game and wants to climb to the top of the leaderboard. Can you help her track her ranking as she beats each level? The game uses Dense Ranking, so its leaderboard works like this:
 *
 * The player with the highest score is ranked number  on the leaderboard.
 * Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately following ranking number.
 * For example, four players have the scores , , , and . Those players will have ranks , , , and , respectively.
 *
 * When Alice starts playing, there are already  people on the leaderboard. The score of each player  is denoted by . Alice plays for  levels, and we denote her total score after passing each level  as . After completing each level, Alice wants to know her current rank.
 *
 * You are given an array, , of monotonically decreasing leaderboard scores, and another array, , of Alice's cumulative scores for each level of the game. You must print  integers. The  integer should indicate the current rank of alice after passing the  level.
 *
 * Input Format
 *
 * The first line contains an integer, , denoting the number of players already on the leaderboard.
 * The next line contains  space-separated integers describing the respective values of .
 * The next line contains an integer, , denoting the number of levels Alice beats.
 * The last line contains  space-separated integers describing the respective values of .
 *
 * Constraints
 *
 * for
 * for
 * The existing leaderboard, , is in descending order.
 * Alice's scores are cumulative, so  is in ascending order.
 * Subtask
 *
 * For  of the maximum score:
 *
 * Output Format
 *
 * Print  integers. The  integer should indicate the rank of alice after passing the  level.
 *
 * Sample Input 0
 *
 * 7
 * 100 100 50 40 40 20 10
 * 4
 * 5 25 50 120
 * Sample Output 0
 *
 * 6
 * 4
 * 2
 * 1
 * Explanation 0
 *
 * Alice starts playing with  players already on the leaderboard, which looks like this:
 *
 * image
 *
 * After Alice finishes level , her score is  and her ranking is :
 *
 * image
 *
 * After Alice finishes level , her score is  and her ranking is :
 *
 * image
 *
 * After Alice finishes level , her score is  and her ranking is tied with Caroline at :
 *
 * image
 *
 * After Alice finishes level , her score is  and her ranking is :
 *
 * image
 * </pre>
 * Created by jason on 17-12-26.
 */
public class Climbing_the_Leaderboard {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] scores = new int[n];
//        for (int scores_i = 0; scores_i < n; scores_i++) {
//            scores[scores_i] = in.nextInt();
//        }
//        int m = in.nextInt();
//        int[] alice = new int[m];
//        for (int alice_i = 0; alice_i < m; alice_i++) {
//            alice[alice_i] = in.nextInt();
//        }
//        // Write Your Code Here
//        in.close();
        int n = 7;
        int m = 4;
        int[] scores = new int[]{100, 100, 50, 40, 40, 20, 10};
        int[] alice = new int[]{5, 25, 50, 120};

        int[] array = range(0, n).map(i -> scores[n - i - 1]).distinct().toArray();
        int index = 0;
        for (int score : alice) {
            index = binarySearch(array, index < 0 ? 0 : index, array.length, score);
            if (index < 0) index = -index - 2;
            System.out.println(array.length - index);
        }

        for (int p : alice) {
            int k = getPosition(scores, p, scores.length - 1);
            System.out.println(k);
        }


    }


    private static int getPosition(int[] ar, int p, int lastP) {
        int t = 1;
        if (p >= ar[0]) {
            return 1;
        }
        for (int i = 1; i < lastP; i++) {
            if (ar[i] != ar[i - 1]) {
                t++;
            }
            if (p >= ar[i]) {
                break;
            }
        }
        if (p < ar[lastP]) {
            t++;
        }
        return t;
    }
}
