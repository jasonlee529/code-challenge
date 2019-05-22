package cn.lee.lintcode.cat;

/**
 * https://www.lintcode.com/problem/implement-strstr/description?_from=cat
 */
public class Question13 {
    public int strStr(String source, String target) {
        if(source.equals(target)){
            return 0;
        }
        char[] srcs = source.toCharArray();
        char[] dest = target.toCharArray();
        for (int i = 0; i < source.length(); i++) {
            if (srcs[i] == dest[0]) {
                boolean pk = true;
                for (int j = 1; j < dest.length; j++) {
                    if (srcs[i + j] == dest[j]) {

                    } else {
                        pk = false;
                        break;
                    }
                }
                if(pk){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Question13 question = new Question13();
        System.out.println(question.strStr("source", "target"));
        System.out.println(question.strStr("", ""));
    }
}
