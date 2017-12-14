package cn.lee.hackerrank.algrithms.implementation;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/picking-numbers/problem
 * <pre>
 * Given an array of integers, find and print the maximum number of integers you can select from the array such that the absolute difference between any two of the chosen integers is .
 *
 * Input Format
 *
 * The first line contains a single integer, , denoting the size of the array.
 * The second line contains  space-separated integers describing the respective values of .
 *
 * Constraints
 *
 * The answer will be .
 * Output Format
 *
 * A single integer denoting the maximum number of integers you can choose from the array such that the absolute difference between any two of the chosen integers is .
 *
 * Sample Input 0
 *
 * 6
 * 4 6 5 3 3 1
 * Sample Output 0
 *
 * 3
 * Explanation 0
 *
 * We choose the following multiset of integers from the array: . Each pair in the multiset has an absolute difference  (i.e.,  and ), so we print the number of chosen integers, , as our answer.
 *
 * Sample Input 1
 *
 * 6
 * 1 2 2 3 1 2
 * Sample Output 1
 *
 * 5
 * Explanation 1
 *
 * We choose the following multiset of integers from the array: . Each pair in the multiset has an absolute difference  (i.e., , , and ), so we print the number of chosen integers, , as our answer.
 * We choose the following multiset of integers from the array: . Each pair in the multiset has an absolute difference  (i.e., , , and ), so we print the number of chosen integers, , as our answer.
 *
 * </pre>
 * Created by jason on 17-12-6.
 */
public class PickingNumbers {

    public static void main(String[] args) {
        System.out.println(pickNumbers(new int[]{4, 97, 5, 97, 97, 4, 97, 4, 97, 97, 97, 97, 4, 4, 5, 5, 97, 5, 97, 99, 4, 97, 5, 97, 97, 97, 5, 5, 97, 4, 5, 97, 97, 5, 97, 4, 97, 5, 4, 4, 97, 5, 5, 5, 4, 97, 97, 4, 97, 5, 4, 4, 97, 97, 97, 5, 5, 97, 4, 97, 97, 5, 4, 97, 97, 4, 97, 97, 97, 5, 4, 4, 97, 4, 4, 97, 5, 97, 97, 97, 97, 4, 97, 5, 97, 5, 4, 97, 4, 5, 97, 97, 5, 97, 5, 97, 5, 97, 97, 97}));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        System.out.println(pickNumbers(a));
    }

    private static int pickNumbers(int[] a) {
        Map<Integer, Integer> datas = new LinkedHashMap<Integer, Integer>();
        for (int i : a) {
            if (!datas.containsKey(i)) {
                datas.put(i, 0);
            }
            datas.put(i, datas.get(i) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(datas.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getKey() - o1.getKey();
            }
        });
        int m = list.get(0).getValue();
        for (int i = 1; i < list.size(); i++) {
            m = m > list.get(i).getValue() ? m : list.get(i).getValue();
            if (Math.abs(list.get(i).getKey() - list.get(i - 1).getKey()) <= 1) {
                int t = list.get(i).getValue() + list.get(i - 1).getValue();
                m = m > t ? m : t;
            }
        }
        return m;
    }

}
