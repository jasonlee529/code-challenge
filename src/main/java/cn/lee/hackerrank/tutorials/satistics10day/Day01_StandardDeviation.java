package cn.lee.hackerrank.tutorials.satistics10day;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/s10-standard-deviation/problem
 * <p>
 * <pre>
 *     Objective
 * In this challenge, we practice calculating standard deviation. Check out the Tutorial tab for learning materials and an instructional video!
 *
 * Task
 * Given an array, , of  integers, calculate and print the standard deviation. Your answer should be in decimal form, rounded to a scale of  decimal place (i.e.,  format). An error margin of  will be tolerated for the standard deviation.
 *
 * Input Format
 *
 * The first line contains an integer, , denoting the number of elements in the array.
 * The second line contains  space-separated integers describing the respective elements of the array.
 *
 * Constraints
 *
 * , where  is the  element of array .
 * Output Format
 *
 * Print the standard deviation on a new line, rounded to a scale of  decimal place (i.e.,  format).
 *
 * Sample Input
 *
 * 5
 * 10 40 30 50 20
 * Sample Output
 *
 * 14.1
 * Explanation
 *
 * First, we find the mean:
 * Next, we calculate the squared distance from the mean, , for each :
 *
 * Now we can compute , so:
 *
 * Once rounded to a scale of  decimal place, our result is .
 * </pre>
 * Created by jason on 17-12-21.
 */
public class Day01_StandardDeviation {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] ar = new int[n];
//        for (int i = 0; i < n; i++) {
//            ar[i] = sc.nextInt();
//        }
        int[]ar=new int[]{10 ,40 ,30 ,50 ,20};
        double r = deviation(ar);
        System.out.println(String.format("%2.1f",r));
    }

    private static double deviation(int[] ar) {
        double mean = mean(ar);
        double sum=0;
        for(int i:ar){
            sum+=Math.pow(i-mean,2);
        }
        return Math.sqrt(sum/ar.length);
    }

    private static double mean(int[] ar) {
        double sum = 0L;
        for (int i : ar) {
            sum = sum + i;
        }
        return sum / ar.length;
    }
}
