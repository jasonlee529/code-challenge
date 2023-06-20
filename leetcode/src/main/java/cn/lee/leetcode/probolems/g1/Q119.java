package cn.lee.leetcode.probolems.g1;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: Q119
 * @Description: https://leetcode-cn.com/problems/pascals-triangle-ii/
 * @author: libo
 * @date: 2020/9/14 14:17
 * @Version: 1.0
 */
@Slf4j
public class Q119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = generate(rowIndex);
        return res.get(rowIndex );
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
                for (int j = 1; j < i; j++) {
                    tmp.add(j, pre.get(j - 1) + pre.get(j));
                }
                tmp.add(1);
            }
            pre = tmp;
            res.add(tmp);
        }
        return res;
    }
}
