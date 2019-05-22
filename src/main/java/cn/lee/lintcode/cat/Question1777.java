package cn.lee.lintcode.cat;

/**
 * https://www.lintcode.com/problem/a-b-problem/description?_from=cat
 */
public class Question1777 {
    public double getArea(double r) {
        // write your code here
        double pi = 3.14;
        return pi * r * r;
    }

    public static void main(String[] args) {
        Question1777 question = new Question1777();
        System.out.println(question.getArea(1));
        System.out.println(question.getArea(2));
    }
}
