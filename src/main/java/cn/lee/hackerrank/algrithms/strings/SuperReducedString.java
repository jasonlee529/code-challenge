package cn.lee.hackerrank.algrithms.strings;

/**
 * <pre>
 *     Steve has a string, , consisting of  lowercase English alphabetic letters. In one operation, he can delete any pair of adjacent letters with same value. For example, string "aabcc" would become either "aab" or "bcc" after operation.
 *
 * Steve wants to reduce  as much as possible. To do this, he will repeat the above operation as many times as it can be performed. Help Steve out by finding and printing 's non-reducible form!
 *
 * Note: If the final string is empty, print Empty String .
 *
 * Input Format
 *
 * A single string, .
 *
 * Constraints
 *
 * Output Format
 *
 * If the final string is empty, print Empty String; otherwise, print the final non-reducible string.
 *
 * Sample Input 0
 *
 * aaabccddd
 * Sample Output 0
 *
 * abd
 * Sample Case 0
 *
 * Steve can perform the following sequence of operations to get the final string:
 *
 * aaabccddd → abccddd
 * abccddd → abddd
 * abddd → abd
 * Thus, we print abd.
 *
 * Sample Input 1
 *
 * baab
 * Sample Output 1
 *
 * Empty String
 * Explanation 1
 *
 * Steve can perform the following sequence of operations to get the final string:
 *
 * baab → bb
 * bb → Empty String
 * Thus, we print Empty String.
 *
 * Sample Input 2
 *
 * aa
 * Sample Output 2
 *
 * Empty String
 * Explanation 2
 *
 * Steve can perform the following sequence of operations to get the final string:
 *
 * aa → Empty String
 * Thus, we print Empty String.
 * </pre>
 * Created by jason on 17-11-23.
 */
public class SuperReducedString {
    static String super_reduced_string(String s) {
        // Complete this function
        int maxLength = s.length();
        int cur = 0;
        while (maxLength - 1 > cur) {
            if (s.charAt(cur) == s.charAt(cur + 1)) {
                s = s.replace(new String(new char[]{s.charAt(cur), s.charAt(cur)}), "");
                cur = 0;
                maxLength = s.length();
            } else {
                cur++;
            }
        }
        if(s.length() ==0){
            s = "Empty String";
        }
        return s;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.next();
        String result = super_reduced_string("aab");
        System.out.println(result);
        System.out.println(super_reduced_string("aa"));
        System.out.println(super_reduced_string("baab"));
        System.out.println(super_reduced_string("aaabccddd"));
        System.out.println(super_reduced_string("aa"));
    }
}
