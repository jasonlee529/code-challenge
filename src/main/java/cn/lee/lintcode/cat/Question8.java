package cn.lee.lintcode.cat;

import java.util.Scanner;

public class Question8 {

    public void rotateString(char[] str, int offset) {
        if(str.length>0 && offset>0){
            offset = offset % str.length;
            if (offset > 0) {
                char[] dest = str.clone();
                int len = str.length;
                for (int i = 0; i < len; i++) {
                    str[(i + offset) % len] = dest[i];
                }
            }
        }

        System.out.println(new String(str));
        System.out.println(str[0] + " " + str[1] + " " + str[2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        int i = sc.nextInt();
        Question8 question8 = new Question8();
//         question8.rotateString(str.toCharArray(),i);
        question8.rotateString("abcdefg".toCharArray(), 3);
        question8.rotateString("".toCharArray(), 10);
    }
    //abcdefg
}
