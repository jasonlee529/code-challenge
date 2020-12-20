package cn.lee.newcoder.bytedance.test;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * @Title: Q1
 * @Description: https://www.nowcoder.com/question/next?pid=16516564&qid=362291&tid=40123075
 * @author: libo
 * @date: 2020/12/20 14:22
 * @Version: 1.0
 */
@Slf4j
public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
            normal(arr[i]);
        }
    }

    private static void normal(String s) {
        boolean isOk = false;
        do {
        } while (!isOk);

    }
}
