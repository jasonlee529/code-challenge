package cn.lee.hackerrank.tutorials.satistics10day;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/s10-interquartile-range/problem
 * <pre>
 * Objective
 * In this challenge, we practice calculating the interquartile range. We recommend you complete the Quartiles challenge before attempting this problem.
 *
 * Task
 * The interquartile range of an array is the difference between its first () and third () quartiles (i.e., ).
 *
 * Given an array, , of  integers and an array, , representing the respective frequencies of 's elements, construct a data set, , where each  occurs at frequency . Then calculate and print 's interquartile range, rounded to a scale of  decimal place (i.e.,  format).
 *
 * Tip: Be careful to not use integer division when averaging the middle two elements for a data set with an even number of elements, and be sure to not include the median in your upper and lower data sets.
 *
 * Input Format
 *
 * The first line contains an integer, , denoting the number of elements in arrays  and .
 * The second line contains  space-separated integers describing the respective elements of array .
 * The third line contains  space-separated integers describing the respective elements of array .
 *
 * Constraints
 *
 * , where  is the  element of array .
 * , where  is the  element of array .
 * The number of elements in  is equal to .
 * Output Format
 *
 * Print the interquartile range for the expanded data set on a new line. Round your answer to a scale of  decimal place (i.e.,  format).
 *
 * Sample Input
 *
 * 6
 * 6 12 8 10 20 16
 * 5 4 3 2 1 5
 * Sample Output
 *
 * 9.0
 * Explanation
 *
 * The given data is:
 *
 * InterquartileRange
 *
 * First, we create data set  containing the data from set  at the respective frequencies specified by :
 * As there are an even number of data points in the original ordered data set, we will split this data set exactly in half:
 *
 * Lower half (L): 6, 6, 6, 6, 6, 8, 8, 8, 10, 10
 *
 * Upper half (U): 12, 12, 12, 12, 16, 16, 16, 16, 16, 20
 *
 * Next, we find . There are  elements in  half, so  is the average of the middle two elements:  and . Thus, .
 *
 * Next, we find .There are  elements in  half, so  is the average of the middle two elements:  and . Thus, .
 *
 * From this, we calculate the interquartile range as  and print  as our answer.
 *
 * </pre>
 * Created by jason on 17-12-21.
 */
public class Day01_Interquartile_Range {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        int[] fr = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            fr[i] = sc.nextInt();
        }
//        int n = 6;
//        int[] ar = new int[]{6, 12, 8, 10, 20, 16};
//        int[] fr = new int[]{5, 4, 3, 2, 1, 5};
        ar = completion(ar, fr);
        double[] r = quartiles(ar);
        System.out.println(String.format("%1.1f",r[2] - r[0]));
    }

    private static int[] completion(int[] ar, int[] fr) {
        int sum = 0;
        for (int i : fr) {
            sum += i;
        }
        int[] r = new int[sum];
        int t = 0;
        for (int i = 0; i < fr.length; i++) {
            int a = ar[i];
            for (int j = 0; j < fr[i]; j++) {
                r[t] = a;
                t++;
            }
        }
        ar = r;
        return ar;
    }


    private static double[] quartiles(int[] ar) {
        int n = ar.length;
        Arrays.sort(ar);
        int a1 = (int) Math.floor(n / 2);
        int a2 = (int) Math.ceil(n / 2);
        int[] left = new int[a1];
        int[] right = new int[a2];
        System.arraycopy(ar, 0, left, 0, a1);
        System.arraycopy(ar, a2 + 1, right, 0, n - a2 - 1);
        double[] r = new double[3];
        r[0] = median(left);
        r[1] = median(ar);
        r[2] = median(right);
        return r;

    }

    private static double median(int[] ar) {
        double l = ar.length - 1;
        Arrays.sort(ar);
        int a1 = (int) Math.floor(l / 2);
        int a2 = (int) Math.ceil(l / 2);
        return (ar[a1] + ar[a2]) / 2;
    }
}
