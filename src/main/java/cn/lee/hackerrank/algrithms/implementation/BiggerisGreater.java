package cn.lee.hackerrank.algrithms.implementation;

import java.util.ArrayList;
import java.util.Arrays;
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
        // squgtpsijhqpqvfbvldseqerinejdiivrqjflpphtkycofrkuzrvwucohhvoylqafwervlhiscwvfbbmhevgmccbrpgnwptxhr
        biggest(new String[]{"abcd"
        });
        // biggest(input());
    }

    private static void biggest(String[] strings) {
        for (String str : strings) {
            findBigest(str);
        }
    }

    private static String findBigest(String str) {
        String result = "no answer";
        List<String> list = new ArrayList<String>();
        arranged(list, str.toCharArray(), 0);
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
            a1 += t * Math.pow(26, src.length() - i);
        }
        return a1;
    }

    private static void arranged(List<String> result, char[] chs, int start) {
        char[] des = new char[chs.length];
        for (int i = 0; i < chs.length; i++) {
            for (int j = 0; j < chs.length; j++) {

            }
        }
        if (start == (chs.length - 1)) {

        }
        if (start == chs.length - 1) {
            Arrays.toString(chs);
            //如果已经到了数组的最后一个元素，前面的元素已经排好，输出。
        }
        for (int i = start; i <= chs.length - 1; i++) {
            //把第一个元素分别与后面的元素进行交换，递归的调用其子数组进行排序
            swap(chs, i, start);
            arranged(result, chs, start + 1);
            result.add(new String(chs));
            swap(chs, i, start);
            //子数组排序返回后要将第一个元素交换回来。
            //如果不交换回来会出错，比如说第一次1、2交换，第一个位置为2，子数组排序返回后如果不将1、2
            //交换回来第二次交换的时候就会将2、3交换，因此必须将1、2交换使1还是在第一个位置
        }
    }

    public static void swap(char chs[], int i, int j) {
        char temp;
        temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
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
