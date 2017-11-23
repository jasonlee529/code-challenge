package cn.lee.hackerrank.algrithm.implementation;

import java.util.*;

/**
 * <pre>
 *
 *     A flock of  birds is flying across the continent. Each bird has a type, and the different types are designated by the ID numbers , , , , and .
 *
 * Given an array of  integers where each integer describes the type of a bird in the flock, find and print the type number of the most common bird. If two or more types of birds are equally common, choose the type with the smallest ID number.
 *
 * Input Format
 *
 * The first line contains an integer denoting  (the number of birds).
 * The second line contains  space-separated integers describing the respective type numbers of each bird in the flock.
 *
 * Constraints
 *
 * It is guaranteed that each type is , , , , or .
 * Output Format
 *
 * Print the type number of the most common bird; if two or more types of birds are equally common, choose the type with the smallest ID number.
 *
 * Sample Input 0
 *
 * 6
 * 1 4 4 4 5 3
 * Sample Output 0
 *
 * 4
 * Explanation 0
 *
 * The different types of birds occur in the following frequencies:
 *
 * Type :  bird
 * Type :  birds
 * Type :  bird
 * Type :  birds
 * Type :  bird
 * The type number that occurs at the highest frequency is type , so we print  as our answer.
 * </pre>
 * Created by jason on 17-11-23.
 */
public class MigratoryBirds {

    static int migratoryBirds(int n, int[] ar) {
        // Complete this function
        Map<Integer, Integer> times = new TreeMap<Integer, Integer>();
        for (int t : ar) {
            if (times.get(t) != null) {
                times.put(t, times.get(t) + 1);
            } else {
                times.put(t, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(times.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue() == 0 ? o2.getKey() - o1.getKey() : o1.getValue() - o2.getValue();
            }
        });
        return list.get(0).getKey();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int ar_i = 0; ar_i < n; ar_i++) {
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}
