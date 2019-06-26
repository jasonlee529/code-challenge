package cn.lee.lintcode.cat;

/**
 * https://www.lintcode.com/problem/trailing-zeros/my-submissions
 */
public class Question2 {

    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        long t = 0;
//        long tmp = 1;
//        for (int i = 2; i <= n; i++) {
//            tmp *= i;
//        }
//        String strs = tmp + "";
//        for (int i = strs.length()-1; i > 0; i--) {
//            if (strs.charAt(i) == '0') {
//                t++;
//            }
//            if (strs.charAt(i - 1) != '0') {
//                break;
//            }
//        }
        while (n > 0) {
            n = n / 5;
            t += n;
        }
        return t;
    }

    public static void main(String[] args) {
        Question2 question = new Question2();
        System.out.println(question.trailingZeros(11));
        System.out.println(question.trailingZeros(5));
        System.out.println(question.trailingZeros(105));

    }
}
