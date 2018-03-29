package cn.lee.hackerrank.algrithms.implementation.Circular_Array_Rotation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/circular-array-rotation/problem
 * <p>
 * John Watson knows of an operation called a right circular rotation on an array of integers. One rotation operation moves the last array element to the first position and shifts all remaining elements right one. To test Sherlock's abilities, Watson provides Sherlock with an array of integers. Sherlock is to perform the rotation operation a number of times then determine the value of the element at a given position.
 * <p>
 * For each array, perform a number of right circular rotations and return the value of the element at a given index.
 * <p>
 * Input Format
 * <p>
 * The first line contains  space-separated integers, , , and .
 * The second line contains  space-separated integers, where each integer  describes array element  (where ).
 * Each of the  subsequent lines contains a single integer denoting .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * For each query, print the value of the element at index  of the rotated array on a new line.
 * <p>
 * Sample Input 0
 * <p>
 * 3 2 3
 * 1 2 3
 * 0
 * 1
 * 2
 * Sample Output 0
 * <p>
 * 2
 * 3
 * 1
 * Explanation 0
 * <p>
 * After the first rotation, the array becomes .
 * After the second (and final) rotation, the array becomes .
 * <p>
 * Let's refer to the array's final state as array . For each query, we just have to print the value of  on a new line:
 * <p>
 * , .
 * , .
 * , .
 */
public class Solution {
    static int[] circularArrayRotation(int[] a,int k, int[] m) {
        int result []=new int[m.length];
        int mod=k%a.length;
        for(int i=0;i<m.length;i++){
            int p = m[i]-mod<0?m[i]-mod+a.length:m[i]-mod;
            result[i]=a[p];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] m = new int[q];
        for(int m_i = 0; m_i < q; m_i++){
            m[m_i] = in.nextInt();
        }
        int[] result = circularArrayRotation(a,k, m);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
