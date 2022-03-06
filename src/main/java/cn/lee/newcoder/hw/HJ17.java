package cn.lee.newcoder.hw;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Title: HJ17
 * @Description:
 * @author: libo
 * @date: 2022/3/6 0006 17:26
 * @Version: 1.0
 */
@Slf4j
public class HJ17 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
        String input="ABC;AKL;DA1;";
        int[] pos = new int[2];
        for (String s : input.split(";")) {
            if (isCommand(s)) {
                pos = move(pos, s);
            }
        }
        System.out.println(pos[0] + "," + pos[1]);
    }

    private static int[] move(int[] srcPos, String command) {
        char start = command.charAt(0);
        int num = Integer.valueOf(command.substring(1));
        switch (start) {
            case 'A':
                srcPos[0] -= num;
                break;
            case 'W':
                srcPos[1] += num;
                break;
            case 'S':
                srcPos[1] -= num;
                break;
            case 'D':
                srcPos[0] += num;
                break;

        }
        return srcPos;
    }

    private static boolean isCommand(String s) {
        boolean is = true;
        if(s==null ||s.length()==0){
            return false;
        }
        char start = s.charAt(0);
        if (start == 'A' || start == 'W' || start == 'S' || start == 'D') {
            String num = s.substring(1);
            String pattern = "^[0-9]*$";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(num);
            return m.find();
        } else {
            is = false;
        }
        return is;
    }
}