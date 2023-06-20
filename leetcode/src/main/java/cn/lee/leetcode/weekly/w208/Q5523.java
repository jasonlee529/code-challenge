package cn.lee.leetcode.weekly.w208;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Title: Q5523
 * @Description: https://leetcode-cn.com/problems/crawler-log-folder/
 * @author: libo
 * @date: 2020/9/27 14:43
 * @Version: 1.0
 */
@Slf4j
public class Q5523 {
    public static void main(String[] args) {
        System.out.println(new Q5523().minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}));
    }

    public int minOperations(String[] logs) {
        Deque<String> path = new ArrayDeque<>();
        for (String str : logs) {
            if("../".equals(str)){
                path.pollLast();
            }else if("./".equals(str)){

            }else{
                path.add(str);
            }
        }
        return path.size();
    }
}
