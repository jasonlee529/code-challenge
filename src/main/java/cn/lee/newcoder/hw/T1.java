package cn.lee.newcoder.hw;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * @Title: T1
 * @Description:
 * @author: libo
 * @date: 2022/3/6 0006 23:00
 * @Version: 1.0
 */
@Slf4j
public class T1 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
                int a = in.nextInt();
                int b = in.nextInt();
                System.out.println(a + b);
            }
        }
}