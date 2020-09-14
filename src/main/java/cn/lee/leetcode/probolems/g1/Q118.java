package cn.lee.leetcode.probolems.g1;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: Q118
 * @Description: https://leetcode-cn.com/problems/pascals-triangle/
 * @author: libo
 * @date: 2020/9/14 11:37
 * @Version: 1.0
 */
@Slf4j
public class Q118 {
    public static void main(String[] args) {
        System.out.println(new Q118().generate(1));
        System.out.println(new Q118().generate(2));
        System.out.println(new Q118().generate(3));
        System.out.println(new Q118().generate(4));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> pre = null;
        for (int i = 0; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            if (i == 0) {
                tmp.add(1);
            } else {
                tmp.add(0, 1);
                for (int j = 1; j < i ; j++) {
                    tmp.add(j,pre.get(j-1)+pre.get(j));
                }
                tmp.add( 1);
            }
            pre = tmp;
            res.add(tmp);
        }
        return res;
    }
}
