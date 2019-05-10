package cn.lee.lintcode.cat;

import java.util.Scanner;

public class Question8 {

    public void rotateString(char[] str, int offset) {
        String string = new String(str);
        // write your code here
        while(offset>0){
            char t = string.charAt(str.length-1);
            string = string.substring(0,str.length-1);
            string = t + string;
            offset--;
        }
        System.out.println(string);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        int i = sc.nextInt();
        Question8 question8 = new Question8();
//         question8.rotateString(str.toCharArray(),i);
        question8.rotateString("abcdefg".toCharArray(),3);
    }
    //abcdefg
}
