package cn.lee.hackerrank.tutorials.code30days;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.hackerrank.com/challenges/30-regex-patterns/problem
 * <pre>
 *     Objective
 * Today, we're working with regular expressions. Check out the Tutorial tab for learning materials and an instructional video!
 *
 * Task
 * Consider a database table, Emails, which has the attributes First Name and Email ID. Given  rows of data simulating the Emails table, print an alphabetically-ordered list of people whose email address ends in .
 *
 * Input Format
 *
 * The first line contains an integer, , total number of rows in the table.
 * Each of the  subsequent lines contains  space-separated strings denoting a person's first name and email ID, respectively.
 *
 * Constraints
 *
 * Each of the first names consists of lower case letters  only.
 * Each of the email IDs consists of lower case letters ,  and  only.
 * The length of the first name is no longer than 20.
 * The length of the email ID is no longer than 50.
 * Output Format
 *
 * Print an alphabetically-ordered list of first names for every user with a gmail account. Each name must be printed on a new line.
 *
 * Sample Input
 *
 * 6
 * riya riya@gmail.com
 * julia julia@julia.me
 * julia sjulia@gmail.com
 * julia julia@gmail.com
 * samantha samantha@gmail.com
 * tanya tanya@gmail.com
 * Sample Output
 *
 * julia
 * julia
 * riya
 * samantha
 * tanya
 * </pre>
 * Created by jason on 17-12-29.
 */
public class Day28_RegEx_Patterns_and_Intro_to_Databases {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String[] ar = new String[n];
//        sc.nextLine();
//        for (int i = 0; i < n; i++) {
//            ar[i] = sc.nextLine();
//        }
        String[] ar = new String[]{"riya riya@gmail.com",
                "julia julia@julia.me",
                "julia sjulia@gmail.com",
                "julia julia@gmail.com",
                "samantha samantha@gmail.com",
                "tanya tanya@gmail.com",
                "riya ariya@gmail.com",
                "julia bjulia@julia.me",
                "julia csjulia@gmail.com",
                "julia djulia@gmail.com",
                "samantha esamantha@gmail.com",
                "tanya ftanya@gmail.com",
                "riya riya@live.com",
                "julia julia@live.com",
                "julia sjulia@live.com",
                "julia julia@live.com",
                "samantha samantha@live.com",
                "tanya tanya@live.com",
                "riya ariya@live.com",
                "julia bjulia@live.com",
                "julia csjulia@live.com",
                "julia djulia@live.com",
                "samantha esamantha@live.com",
                "tanya ftanya@live.com",
                "riya gmail@riya.com",
                "priya priya@gmail.com",
                "preeti preeti@gmail.com",
                "alice alice@alicegmail.com",
                "alice alice@gmail.com",
                "alice gmail.alice@gmail.com"};
        filterName(ar);
    }

    private static void filterName(String[] ar) {
        final String REG = "[a-z|.]+@gmail.[a-z]*";
        Pattern p = Pattern.compile(REG);
        List<String> dest = new ArrayList<>();
        for (String s : ar) {
            int pos = s.indexOf(" ");
            String prefix = s.substring(0, pos);
            String sub = s.substring(pos + 1);
            Matcher m = p.matcher(sub);
            if (m.matches()) {
                dest.add(prefix);
            }
        }
        Collections.sort(dest);
        for (String str : dest) {
            System.out.println(str);
        }
    }
}
