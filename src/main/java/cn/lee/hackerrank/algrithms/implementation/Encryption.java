package cn.lee.hackerrank.algrithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/encryption/problem
 * <pre>
 *     An English text needs to be encrypted using the following encryption scheme.
 * First, the spaces are removed from the text. Let  be the length of this text.
 * Then, characters are written into a grid, whose rows and columns have the following constraints:
 *
 * , where  is floor function and  is ceil function
 * For example, the sentence if man was meant to stay on the ground god would have given us roots after removing spaces is  characters long, so it is written in the form of a grid with 7 rows and 8 columns.
 *
 * ifmanwas
 * meanttos
 * tayonthe
 * groundgo
 * dwouldha
 * vegivenu
 * sroots
 * Ensure that
 * If multiple grids satisfy the above conditions, choose the one with the minimum area, i.e. .
 * The encoded message is obtained by displaying the characters in a column, inserting a space, and then displaying the next column and inserting a space, and so on. For example, the encoded message for the above rectangle is:
 *
 * imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau
 *
 * You will be given a message in English with no spaces between the words. The maximum message length can be  characters. Print the encoded message.
 *
 * Here are some more examples:
 *
 * Sample Input:
 *
 * haveaniceday
 * Sample Output:
 *
 * hae and via ecy
 * Sample Input:
 *
 * feedthedog
 * Sample Output:
 *
 * fto ehg ee dd
 * Sample Input:
 *
 * chillout
 * Sample Output:
 *
 * clu hlt io
 * </pre>
 * Created by jason on 17-12-12.
 */
public class Encryption {

    public static void main(String[] args) {
        encrypt("chillout");
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String stb = encrypt(str);
    }

    private static String encrypt(String str) {
        str = str.replaceAll("\\s", "");
        StringBuilder sb = new StringBuilder();
        int L = str.length();
        int fL = (int) Math.floor(Math.sqrt(L));
        int cL = (int) Math.ceil(Math.sqrt(L));
        int rows = fL;
        int columns = cL;
        int mul = cL * cL;
        for (int i = fL; i <= cL; i++) {
            for (int j = i; j <= cL; j++) {
                if (i * j >= L && i * j <= mul) {
                    rows = i;
                    columns = j;
                }
            }
        }

        char[][] ar = new char[rows][columns];
        for (int i = 0; i < str.length(); i++) {
            ar[i / columns][i % columns] = str.charAt(i);
        }
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (ar[j][i] != '\u0000') {
                    sb.append(ar[j][i]);
                }
            }
            if (i < columns - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString().trim());
        return sb.toString();
    }
}
