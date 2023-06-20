package cn.lee.leetcode.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;

/**
    * @Title: Utils
    * @Description: 
    * @author: libo
    * @date: 2020/9/11 9:21
    * @Version: 1.0
    */
@Slf4j
public class Utils {
    public static int sumPath(Deque<Integer> path) {
        int sum = 0;
        for (int i : path) {
            sum += i;
        }
        return sum;
    }
}
