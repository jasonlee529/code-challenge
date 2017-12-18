package cn.lee.hackerrank.tutorials.code30days;

import java.util.Scanner;

/**
 * Created by jason on 17-12-18.
 */
public class Day17_MoreExceptions {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {

            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();
            try {
                int ans = myCalculator.power(n, p);
                System.out.println(ans);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        in.close();
    }
}

class Calculator {

    public int power(int n, int p) {
        if (n < 0 || p < 0) {
            throw new IllegalArgumentException("n and p should be non-negative");
        }
        int result = 1;
        for (int i = 1; i <= p; i++) {
            result = result * n;
        }
        return result;
    }
}
