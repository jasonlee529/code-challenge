package cn.lee.hackerrank.algrithms.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <pre>
 *     Consider an array of numeric strings, , where each string is a positive number with anywhere from  to  digits. Sort the array's elements in non-decreasing (i.e., ascending) order of their real-world integer values and print each element of the sorted array on a new line.
 *
 * Input Format
 *
 * The first line contains an integer, , denoting the number of strings in .
 * Each of the  subsequent lines contains a string of integers describing an element of the array.
 *
 * Constraints
 *
 * Each string is guaranteed to represent a positive integer without leading zeros.
 * The total number of digits across all strings in  is between  and  (inclusive).
 * Output Format
 *
 * Print each element of the sorted array on a new line.
 *
 * Sample Input 0
 *
 * 6
 * 31415926535897932384626433832795
 * 1
 * 3
 * 10
 * 3
 * 5
 * Sample Output 0
 *
 * 1
 * 3
 * 3
 * 5
 * 10
 * 31415926535897932384626433832795
 * Explanation 0
 *
 * The initial array of strings is . When we order each string by the real-world integer value it represents, we get:
 *
 * We then print each value on a new line, from smallest to largest.
 * </pre>
 * Created by jason on 17-11-27.
 */
public class BigSorting {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        String[] unsorted = new String[n];
//        for (int unsorted_i = 0; unsorted_i < n; unsorted_i++) {
//            unsorted[unsorted_i] = in.next();
//        }
        // your code goes here
        sorting(new String[]{"6",
                "31415926535897932384626433832795",
                "1",
                "3",
                "10",
                "3",
                "5"});
    }

    static void sorting(String[] unsorted) {
        Arrays.sort(unsorted, new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                }
                for (int i = 0; i < o1.length(); i++) {
                    char t1 = o1.charAt(i);
                    char t2 = o2.charAt(i);
                    if (t1 == t2) {
                        continue;
                    } else {
                        return t1 - t2;
                    }
                }
                return 0;
            }
        });
        for (String s : unsorted) {
            System.out.println(s);
        }
    }
}
