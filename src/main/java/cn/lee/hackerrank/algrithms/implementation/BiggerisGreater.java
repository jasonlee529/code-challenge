package cn.lee.hackerrank.algrithms.implementation;

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
        biggest(new String[]{"squgtpsijhqpqvfbvldseqerinejdiivrqjflpphtkycofrkuzrvwucohhvoylqafwervlhiscwvfbbmhevgmccbrpgnwptxhr"
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
        String r = nextPermutation(str.toCharArray());
        if (!str.equalsIgnoreCase(r)) {
            result = r;
        }
        System.out.println(result);
        return result;
    }

    private static String nextPermutation(char[] array) {
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i]) {
            i--;
        }
        if (i <= 0) {
            return new String(array);
        }
        int j = array.length - 1;
        while (array[j] <= array[i - 1]) {
            j--;
        }
        swap(array, i - 1, j);
        j = array.length - 1;
        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }
        return new String(array);
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
