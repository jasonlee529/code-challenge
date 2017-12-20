package cn.lee.hackerrank.tutorials.code30days;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/30-interfaces/problem
 * Created by jason on 17-12-20.
 */
public class Day19_Interfaces {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        AdvancedArithmetic myCalculator = new Calculator2();
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName());
        System.out.println(sum);
    }
}

class Calculator2 implements AdvancedArithmetic {
    public int divisorSum(int n) {
        int sum = 0;
        if (n == 1) {
            return 1;
        }
        for (int i = 1; i * i <= n; i++) {

            if (n % i == 0) {
                sum += i;
                if(i !=n/i){
                    sum += n / i;
                }
            }
        }
        return sum;
    }
}

interface AdvancedArithmetic {
    int divisorSum(int n);
}