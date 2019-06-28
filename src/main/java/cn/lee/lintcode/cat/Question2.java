package cn.lee.lintcode.cat;

/**
 * https://www.lintcode.com/problem/trailing-zeros/my-submissions
 */
public class Question2 {

    public long trailingZeros(long n) {
        long t = 0;
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
