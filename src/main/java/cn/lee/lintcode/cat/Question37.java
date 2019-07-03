package cn.lee.lintcode.cat;

/**
 * https://www.lintcode.com/problem/reverse-3-digit-integer/description
 */
public class Question37 {

    public int reverseInteger(int number) {
        // write your code here
        String string = String.valueOf(number);
        StringBuilder dest = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            dest.append(string.charAt(i));
        }
        return Integer.parseInt(dest.toString());
    }

    public static void main(String[] args) {
        Question37 question = new Question37();
        System.out.println(question.reverseInteger(123));
        System.out.println(question.reverseInteger(900));
        System.out.println(question.reverseInteger(910));
    }
}
