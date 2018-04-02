package cn.lee.hackerrank.Data_Structrue.Arrays_DS;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * An array is a type of data structure that stores elements of the same type in a contiguous block of memory. In an array, , of size , each memory location has some unique index,  (where ), that can be referenced as  (you may also see it written as ).
 * <p>
 * Given an array, , of  integers, print each element in reverse order as a single line of space-separated integers.
 * <p>
 * Note: If you've already solved our C++ domain's Arrays Introduction challenge, you may want to skip this.
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer,  (the number of integers in ).
 * The second line contains  space-separated integers describing .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print all  integers in  in reverse order as a single line of space-separated integers.
 * <p>
 * Sample Input 1
 * <p>
 * CopyDownload
 * Array: arr
 * 1
 * 4
 * 3
 * 2
 * <p>
 * <p>
 * 4
 * 1 4 3 2
 * Sample Output 1
 * <p>
 * 2 3 4 1
 */
public class Solution {

    /*
     * Complete the reverseArray function below.
     */
    static int[] reverseArray(int[] a) {
        /*
         * Write your code here.
         */
        int[] t = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            t[i] = a[a.length - i - 1];
        }
        return t;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(scanner.nextLine().trim());

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");

        for (int arrItr = 0; arrItr < arrCount; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;
        }

        int[] res = reverseArray(arr);

        for (int resItr = 0; resItr < res.length; resItr++) {
            bufferedWriter.write(String.valueOf(res[resItr]));

            if (resItr != res.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
