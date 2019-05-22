package cn.lee.lintcode.cat;

/**
 * https://www.lintcode.com/problem/implement-strstr/description?_from=cat
 */
public class Question53 {
    public String reverseWords(String s) {
        // write your code here
        String[] str = s.split(" ");
        String[] str2 = new String[str.length];
        int len = str.length-1;
        for (int i = 0; i < str.length; i++) {
            str2[i] = str[len - i].trim();
        }
        StringBuilder dest = new StringBuilder();
        String seq="";
        for(String s1 :str2){
            if(!s1.equals("")){
                dest.append(seq).append(s1);
            }
            seq = " ";
        }
        return dest.toString();
    }

    public static void main(String[] args) {
        Question53 question = new Question53();
        System.out.println(question.reverseWords("the sky is blue"));
        System.out.println(question.reverseWords("hello world"));
        System.out.println(question.reverseWords(" Life  doesn't  always    give     us  the       joys we want."));
    }
}
