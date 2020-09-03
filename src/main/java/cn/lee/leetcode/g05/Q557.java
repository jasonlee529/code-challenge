package cn.lee.leetcode.g05;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 */
public class Q557 {
    public String reverseWords(String s) {
        String[] arrs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        String ws = "";
        for (String a : arrs) {
            sb.append(ws);
            for(int i=a.length()-1;i>=0;i--){
                sb.append(a.charAt(i));
            }
            ws=" ";

        }
        return sb.toString();
    }

    private String reverseInner(String a) {
        return null;
    }

}
