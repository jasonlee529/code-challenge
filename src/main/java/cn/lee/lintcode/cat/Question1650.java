package cn.lee.lintcode.cat;

/**
 * https://www.lintcode.com/problem/legal-article/description?_from=cat
 */
public class Question1650 {

    public int count(String s) {
        // Write your code here.
        int count = 0;
        boolean up = true;
        boolean start = true;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                start = true;
            } else if (c == '.') {
                up = true;
            } else if (up && Character.isLowerCase(c)) {
                System.out.println("1  " + up + "__" + c);
                up = false;
                start = false;
                count++;
            } else if (!start && Character.isUpperCase(c)) {
                System.out.println("1  " + up + "__" + c);
                up = false;
                start = false;
                count++;
            } else {
                up = false;
                start = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Question1650 question = new Question1650();
        System.out.println(question.count("This won iz correkt. It has, No Mistakes et Oll. But there are two BIG mistakes in this sentence. and here is one more."));
        System.out.println(question.count("Hahaha. HahaHa. hahahah."));
    }
}
