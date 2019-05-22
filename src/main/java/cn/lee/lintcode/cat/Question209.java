package cn.lee.lintcode.cat;

/**
 * https://www.lintcode.com/problem/unique-characters/description?_from=cat
 */
public class Question209 {
    public char firstUniqChar(String str) {
        int[] counts = new int[Character.MAX_CODE_POINT];
        for (char c : str.toCharArray()) {
            int index = (int)(c);
            counts[index] += 1;
        }
        for (int i=0;i<counts.length;i++) {
            if(counts[i] == 1){
                return (char)(i);
            }
        }
        return '0';
    }

    public static void main(String[] args) {
        Question209 question = new Question209();
        System.out.println(question.firstUniqChar("abaccdeff"));
        System.out.println(question.firstUniqChar("abc"));
    }
}
