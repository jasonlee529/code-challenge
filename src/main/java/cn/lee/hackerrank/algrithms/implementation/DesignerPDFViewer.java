package cn.lee.hackerrank.algrithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/designer-pdf-viewer/problem
 * <pre>
 *     When you select a contiguous block of text in a PDF viewer, the selection is highlighted with a blue rectangle. In a new kind of PDF viewer, the selection of each word is independent of the other words; this means that each rectangular selection area forms independently around each highlighted word. For example:
 *
 * PDF-highighting.png
 *
 * In this type of PDF viewer, the width of the rectangular selection area is equal to the number of letters in the word times the width of a letter, and the height is the maximum height of any letter in the word.
 *
 * Consider a word consisting of lowercase English alphabetic letters, where each letter is  wide. Given the height of each letter in millimeters (), find the total area that will be highlighted by blue rectangle in when the given word is selected in our new PDF viewer.
 *
 * Input Format
 *
 * The first line contains  space-separated integers describing the respective heights of each consecutive lowercase English letter (i.e., ).
 * The second line contains a single word, consisting of lowercase English alphabetic letters.
 *
 * Constraints
 *
 * , where  is an English lowercase letter.
 * Word contains no more than  letters.
 * Output Format
 *
 * Print a single integer denoting the area of highlighted rectangle when the given word is selected. The unit of measurement for this is square millimeters (), but you must only print the integer.
 *
 * Sample Input 0
 *
 * 1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5
 * abc
 * Sample Output 0
 *
 * 9
 * Explanation 0
 *
 * We are highlighting the word abc:
 *
 * The tallest letter in abc is b, and . The selection area for this word is .
 * Note: Recall that the width of each character is .
 *
 * Sample Input 1
 *
 * 1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 7
 * zaba
 * Sample Output 1
 *
 * 28
 * Explanation 1
 *
 * We are highlighting the word :
 *
 * The tallest letter in  is  and  is . The selection area for this word is .
 * </pre>
 * Created by jason on 17-12-7.
 */
public class DesignerPDFViewer {
    public static void main(String[] args) {
        System.out.println((int) 'a');

        design(new int[]{}, "");
    }


    public static void input() {
        Scanner in = new Scanner(System.in);
        int[] h = new int[26];
        for (int h_i = 0; h_i < 26; h_i++) {
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        design(h, word);
    }

    private static void design(int[] ints, String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int h = ints[(int) s.charAt(i) - 97];
            max = max > h ? max : h;
        }
        int result = max * s.length();
        System.out.print(result);
    }

}
