package cn.lee.hackerrank.algrithms.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/bigger-is-greater/problem
 * <pre>
 *
 *     Given a word , rearrange the letters of  to construct another word  in such a way that  is lexicographically greater than . In case of multiple possible answers, find the lexicographically smallest one among them.
 *
 * Input Format
 *
 * The first line of input contains , the number of test cases. Each of the next  lines contains .
 *
 * Constraints
 *
 * will contain only lower-case English letters and its length will not exceed .
 * Output Format
 *
 * For each testcase, output a string lexicographically bigger than  in a separate line. In case of multiple possible answers, print the lexicographically smallest one, and if no answer exists, print no answer.
 *
 * Sample Input 0
 *
 * 5
 * ab
 * bb
 * hefg
 * dhck
 * dkhc
 * Sample Output 0
 *
 * ba
 * no answer
 * hegf
 * dhkc
 * hcdk
 * Explanation 0
 *
 * Test case 1:
 * There exists only one string greater than ab which can be built by rearranging ab. That is ba.
 * Test case 2:
 * Not possible to rearrange bb and get a lexicographically greater string.
 * Test case 3:
 * hegf is the next string lexicographically greater than hefg.
 * Test case 4:
 * dhkc is the next string lexicographically greater than dhck.
 * Test case 5:
 * hcdk is the next string lexicographically greater than dkhc.
 * </pre>
 * Created by jason on 17-12-12.
 */
public class BiggerisGreater {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        biggest(new String[]{"squgtpsijhqpqvfbvldseqerinejdiivrqjflpphtkycofrkuzrvwucohhvoylqafwervlhiscwvfbbmhevgmccbrpgnwptxhr",
                "bb",
                "hefg",
                "dhck",
                "dkhc"});
        // biggest(input());
    }

    private static void biggest(String[] strings) {
        for (String str : strings) {
            findBigest(str);
        }
    }

    private static String findBigest(String str) {
        String result = "no answer";
        List<String> list = arranged(str);
        int min = Integer.MAX_VALUE;
        for (String s : list) {
            int t = compare(str, s);
            if (t > 0 && t < min) {
                result = s;
                min = t;
            }
        }
        System.out.println(result);
        return result;
    }

    private static int compare(String src, String dest) {
        int a1 = 0;
        for (int i = 0; i < src.length(); i++) {
            int t = dest.charAt(i) - src.charAt(i);
            a1 += t*Math.pow(26,src.length()-i);
        }
        return a1;
    }

    private static List<String> arranged(String str) {
        List<String> all = new ArrayList<String>();
        if (str.length() == 1) {
            all.add(str);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String s2 = str.substring(0, i) + str.substring(i + 1);
                List<String> r = arranged(s2);
                for (String s : r) {
                    s = str.charAt(i) + s;
                    all.add(s);
                }
            }
        }
        return all;
    }


    private static String[] input() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        String[] ar = new String[t];
        for (int i = 0; i < t; i++) {
            ar[i] = sc.nextLine();
        }
        sc.close();
        return ar;
    }
}
