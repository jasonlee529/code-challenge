package cn.lee.leetcode.probolems.g4;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: Q412
 * @Description: https://leetcode-cn.com/problems/fizz-buzz/
 * @author: libo
 * @date: 2020/9/21 16:32
 * @Version: 1.0
 */
@Slf4j
public class Q412 {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}
