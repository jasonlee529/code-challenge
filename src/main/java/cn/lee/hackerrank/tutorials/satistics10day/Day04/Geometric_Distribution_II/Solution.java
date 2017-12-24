package cn.lee.hackerrank.tutorials.satistics10day.Day04.Geometric_Distribution_II;

/**
 * https://www.hackerrank.com/challenges/s10-geometric-distribution-2/problem
 * <pre>
 *     Objective
 * Objective
 In this challenge, we go further with geometric distributions. We recommend reviewing the Geometric Distribution tutorial before attempting this challenge.

 Task
 The probability that a machine produces a defective product is . What is the probability that the  defect is found during the first  inspections?

 Input Format

 The first line contains the respective space-separated numerator and denominator for the probability of a defect, and the second line contains the inspection we want the probability of the first defect being discovered by:

 1 3
 5
 If you do not wish to read this information from stdin, you can hard-code it into your program.

 Output Format

 Print a single line denoting the answer, rounded to a scale of  decimal places (i.e.,  format).
 * </pre>
 * Created by jason on 17-12-23.
 */
public class Solution {
    public static void main(String[] args) {
        double r = (double)1 / 3;
        double r2 = 0;
        for(int i=1;i<=5;i++){
            r2+= Math.pow(1-r,i-1)*r;
        }
        System.out.println(String.format("%1.3f",r2));
    }
}
