package cn.lee.hackerrank.hour25;

import java.util.Scanner;

/**
 * Created by jason on 18-1-3.
 */
public class Constructing_a_Number {

    static String canConstruct(int[] a) {
        // Return "Yes" or "No" denoting whether you can construct the required number.
        String result = "No";
        if (a.length == 1) {
            result = a[0] % 3 == 0 ? "Yes" : result;
        }
        StringBuilder sb = new StringBuilder();

        for (int i : a) {
            sb.append(i);
        }
        char[] chars = sb.toString().toCharArray();
        int r = 0;
        for (char c : chars) {
            r += Integer.valueOf(c);
        }
        if (r % 3 == 0) {
            result = "Yes";
        }
        return result;
    }


    public static void main(String[] args) {
        String result = canConstruct(new int[]{181426560, 532466628});
        System.out.println(result);
        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        for (int a0 = 0; a0 < t; a0++) {
//            int n = in.nextInt();
//            int[] a = new int[n];
//            for (int a_i = 0; a_i < n; a_i++) {
//                a[a_i] = in.nextInt();
//            }
//            String result = canConstruct(a);
//            System.out.println(result);
//        }
//        in.close();
    }
}
