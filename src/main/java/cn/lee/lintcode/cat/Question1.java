package cn.lee.lintcode.cat;

/**
 * https://www.lintcode.com/problem/a-b-problem/description?_from=cat
 */
public class Question1 {

    public int aplusb(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return aplusb(sum, carry);
    }

    public static void main(String[] args) {
        Question1 question8 = new Question1();
        System.out.println(question8.aplusb(1, 2));
        System.out.println(question8.aplusb(1, -2));
    }
}
