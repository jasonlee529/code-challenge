package cn.lee.lintcode.cat;

/**
 * https://www.lintcode.com/problem/unique-characters/description?_from=cat
 */
public class Question157 {
    public boolean isUnique(String str) {
        // write your code here
        int[] strs = new int[Character.MAX_CODE_POINT];
        for (char c : str.toCharArray()) {
            int t = (int) c;
            if (strs[t] == 1) {
                return false;
            } else {
                strs[t] = 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Question157 question = new Question157();
        System.out.println(question.isUnique("abc_____"));
        System.out.println(question.isUnique("abc"));
    }
}
