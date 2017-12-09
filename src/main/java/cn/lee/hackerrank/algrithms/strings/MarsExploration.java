package cn.lee.hackerrank.algrithms.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/mars-exploration/problem
 * <pre>Sami's spaceship crashed on Mars! She sends  sequential SOS messages to Earth for help.
 *
 * NASA_Mars_Rover.jpg
 *
 * Letters in some of the SOS messages are altered by cosmic radiation during transmission. Given the signal received by Earth as a string, , determine how many letters of Sami's SOS have been changed by radiation.
 *
 * Input Format
 *
 * There is one line of input: a single string, .
 *
 * Note: As the original message is just SOS repeated  times, 's length will be a multiple of .
 *
 * Constraints
 *
 * will contain only uppercase English letters.
 * Output Format
 *
 * Print the number of letters in Sami's message that were altered by cosmic radiation.
 *
 * Sample Input 0
 *
 * SOSSPSSQSSOR
 * Sample Output 0
 *
 * 3
 * Sample Input 1
 *
 * SOSSOT
 * Sample Output 1
 *
 * 1
 * Explanation
 *
 * Sample 0
 *
 * = SOSSPSSQSSOR, and signal length . Sami sent  SOS messages (i.e.: ).
 *
 * Expected signal: SOSSOSSOSSOS
 * Recieved signal: SOSSPSSQSSOR
 *
 * We print the number of changed letters, which is .
 *
 * Sample 1
 *
 * = SOSSOT, and signal length . Sami sent  SOS messages (i.e.: ).
 *
 * Expected Signal: SOSSOS
 * Received Signal: SOSSOT
 *
 * We print the number of changed letters, which is .
 * </pre>
 * Created by jason on 17-12-8.
 */
public class MarsExploration {


    public static void main(String[] args) {
        sos("SOSOOSOSOSOSOSSOSOSOSOSOSOS");
        Scanner in = new Scanner(System.in);
        String S = in.next();
        sos(S);
    }

    private static void sos(String s) {
        int count = 0;
        if(s.length() % 3 !=0){
            count++;
        }
        String sos = "SOS";
        for (int i = 0; i < s.length()-s.length()%3; i++) {
            if(s.charAt(i) != sos.charAt(i%3)){
                count++;
            }
        }
        System.out.println(count);
    }


}
