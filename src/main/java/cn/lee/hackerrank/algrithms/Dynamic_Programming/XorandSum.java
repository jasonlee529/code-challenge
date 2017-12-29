package cn.lee.hackerrank.algrithms.Dynamic_Programming;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/xor-and-sum/problem
 * <pre>
 *     You are given two positive integers  and  in binary representation. You should find the following sum modulo :
 *
 * where operation  means exclusive OR operation, operation  means binary shift to the left.
 *
 * Please note, that we consider ideal model of binary integers. That is there is infinite number of bits in each number, and there are no disappearings (or cyclic shifts) of bits.
 *
 * Input Format
 *
 * The first line contains number   in binary representation. The second line contains number   in the same format. All the numbers do not contain leading zeros.
 *
 * Output Format
 *
 * Output a single integer  the required sum modulo .
 *
 * Sample Input
 *
 * 10
 * 1010
 * Sample Output
 *
 * 489429555
 * </pre>
 * Created by jason on 17-12-29.
 */
public class XorandSum {
    private static final long MODULE = (long) (Math.pow(10, 9) + 7);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int N = s1.length(), M = s2.length();

        int modulo = (int) Math.pow(10, 9) + 7;
        int shiftLimit = 314159;

        long capacitor = 0, powerCapacitor = 1;

        int[] firstNumberBit = new int[N];
        int[] secondNumberBitCount = new int[M];
        int[] secondNumberInverseBitCount = new int[M];

        for (int i = N - 1; i >= 0; i--) {
            if (s1.charAt(i) == '1') firstNumberBit[N - 1 - i] = 1;
        }
        for (int i = M - 1; i >= 0; i--) {
            int idx = M - 1 - i;
            if (s2.charAt(i) == '1') secondNumberBitCount[idx] = 1;
            if (i < M - 1) secondNumberBitCount[idx] += secondNumberBitCount[idx - 1];
        }
        for (int i = 0; i < M; i++) {
            if (s2.charAt(i) == '1') secondNumberInverseBitCount[i] = 1;
            if (i > 0) secondNumberInverseBitCount[i] += secondNumberInverseBitCount[i - 1];
        }

        for (int p = 0; p < shiftLimit; p++) {
            long bits1 = p < N ? firstNumberBit[p] : 0;
            long bits2 = p < M ? secondNumberBitCount[p] : secondNumberBitCount[M - 1];

            if (bits1 == 1) {
                capacitor += (((shiftLimit + 1) - bits2) * powerCapacitor) % modulo;
            } else {
                capacitor += (bits2 * powerCapacitor) % modulo;
            }
            capacitor %= modulo;

            powerCapacitor = powerCapacitor * 2;
            powerCapacitor %= modulo;
        }

        // extra bits of second number (positions over 314159)
        for (int i = 0; i < M; i++) {
            capacitor += (powerCapacitor * secondNumberInverseBitCount[M - 1 - i]) % modulo;
            capacitor %= modulo;
            powerCapacitor = powerCapacitor * 2;
            powerCapacitor %= modulo;
        }

        System.out.println(capacitor);
    }
}
