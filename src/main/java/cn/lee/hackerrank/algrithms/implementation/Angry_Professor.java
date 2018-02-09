package cn.lee.hackerrank.algrithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/angry-professor/problem
 * A Discrete Mathematics professor has a class of  students. Frustrated with their lack of discipline, he decides to cancel class if fewer than  students are present when class starts.
 * <p>
 * Given the arrival time of each student, determine if the class is canceled.
 * <p>
 * Input Format
 * <p>
 * The first line of input contains , the number of test cases.
 * <p>
 * Each test case consists of two lines. The first line has two space-separated integers,  (students in the class) and  (the cancelation threshold). The second line contains  space-separated integers () describing the arrival times for each student.
 * <p>
 * Note: Non-positive arrival times () indicate the student arrived early or on time; positive arrival times () indicate the student arrived  minutes late.
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * For each test case, print the word YES if the class is canceled or NO if it is not.
 * <p>
 * Note
 * If a student arrives exactly on time , the student is considered to have entered before the class started.
 * <p>
 * Sample Input
 * <p>
 * 2
 * 4 3
 * -1 -3 4 2
 * 4 2
 * 0 -1 2 1
 * Sample Output
 * <p>
 * YES
 * NO
 * Explanation
 * <p>
 * For the first test case, . The professor wants at least  students in attendance, but only  have arrived on time ( and ). Thus, the class is canceled.
 * <p>
 * For the second test case, . The professor wants at least  students in attendance, and there are  who have arrived on time ( and ). Thus, the class is not canceled
 * Created by jason on 18-2-9.
 */
public class Angry_Professor {

    static String angryProfessor(int k, int[] a) {
        // Complete this function
        long arr = Arrays.stream(a).filter( i -> i<=0).count();
//        for(int i:a){
//            arr = i<=0?arr+1:arr;
//        }
//        Arrays.stream(a).filter( i -> i<=0).count();
        return arr>=k?"YES":"NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            for (int a_i = 0; a_i < n; a_i++) {
                a[a_i] = in.nextInt();
            }
            String result = angryProfessor(k, a);
            System.out.println(result);
        }
        in.close();
    }
}
