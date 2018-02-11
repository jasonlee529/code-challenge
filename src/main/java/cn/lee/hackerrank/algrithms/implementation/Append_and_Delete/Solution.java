package cn.lee.hackerrank.algrithms.implementation.Append_and_Delete;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/append-and-delete/problem
 * You have a string, , of lowercase English alphabetic letters. You can perform two types of operations on :
 * <p>
 * Append a lowercase English alphabetic letter to the end of the string.
 * Delete the last character in the string. Performing this operation on an empty string results in an empty string.
 * Given an integer, , and two strings,  and , determine whether or not you can convert  to  by performing exactly  of the above operations on . If it's possible, print Yes; otherwise, print No.
 * <p>
 * Input Format
 * <p>
 * The first line contains a string, , denoting the initial string.
 * The second line contains a string, , denoting the desired final string. The third line contains an integer, , denoting the desired number of operations.
 * <p>
 * Constraints
 * <p>
 * and  consist of lowercase English alphabetic letters.
 * Output Format
 * <p>
 * Print Yes if you can obtain string  by performing exactly  operations on ; otherwise, print No.
 * <p>
 * Sample Input 0
 * <p>
 * hackerhappy
 * hackerrank
 * 9
 * Sample Output 0
 * <p>
 * Yes
 * Explanation 0
 * <p>
 * We perform  delete operations to reduce string  to hacker. Next, we perform  append operations (i.e., r, a, n, and k), to get hackerrank. Because we were able to convert  to  by performing exactly operations, we print Yes.
 * <p>
 * Sample Input 1
 * <p>
 * aba
 * aba
 * 7
 * Sample Output 1
 * <p>
 * Yes
 * Explanation 1
 * <p>
 * We perform  delete operations to reduce string  to the empty string (recall that, though the string will be empty after  deletions, we can still perform a delete operation on an empty string to get the empty string). Next, we perform  append operations (i.e., a, b, and a). Because we were able to convert  to  by performing exactly  operations, we print Yes.
 * <p>
 * Sample Input 2
 * <p>
 * ashley
 * ash
 * 2
 * Sample Output 2
 * <p>
 * No
 * Explanation 2
 * <p>
 * To convert ashley to ash a minimum of  steps are needed. Hence we print No as answer.
 * Created by jason on 18-2-11.
 */
public class Solution {
    static String appendAndDelete(String s, String t, int k) {
        // Complete this function
        int len = Math.min(s.length(), t.length());
        int sub = len;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                sub = i ;
                break;
            }
        }
        int ops = s.length() - sub  + t.length() - sub ;
        if(k>=s.length()+t.length()){
            return "Yes";
        }else if(k>=ops && (k - ops)%2==0){
            return "Yes";
        }
        return "No";
    }

    public static void main(String[] args) {

        System.out.println(appendAndDelete("hackerhappy", "hackerrank", 9));
        System.out.println(appendAndDelete("aba", "aba", 7));
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();
        String result = appendAndDelete(s, t, k);
        System.out.println(result);
        in.close();
    }
}
