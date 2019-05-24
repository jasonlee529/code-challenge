package cn.lee.lintcode.cat;

/**
 * https://www.lintcode.com/problem/legal-identifier/description?_from=cat
 */
public class Question1658 {

    public boolean isLegalIdentifier(String str) {
        // Write your code here.
        if ( null == str || "".equals(str)) {
            return false;
        }
        char start = str.charAt(0);
        if (start >= '0' && start <= '9') {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {

            } else if (c >= 'a' && c <= 'z') {
            } else if (c >= '0' && c <= '9') {
            } else if (c == '_') {

            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Question1658 question = new Question1658();
        System.out.println(question.isLegalIdentifier("LintCode"));
        System.out.println(question.isLegalIdentifier("123_abc"));
    }
}
