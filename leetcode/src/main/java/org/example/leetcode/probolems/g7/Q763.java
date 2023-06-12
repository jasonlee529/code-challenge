package org.example.leetcode.probolems.g7;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: Q763
 * @Description: https://leetcode-cn.com/problems/partition-labels/
 * @author: libo
 * @date: 2020/10/22 13:43
 * @Version: 1.0
 */
@Slf4j
public class Q763 {
    public static void main(String[] args) {
        System.out.println(new Q763().partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(new Q763().partitionLabels("caedbdedda"));
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = left;
        while (right < S.length()) {
            int l1 = left;
            while (l1 < right+1) {
                char c1 = S.charAt(l1);
                for (int i = right+1; i < S.length(); i++) {
                    if (c1 == S.charAt(i)) {
                        right = i;
                    }
                }
                l1++;
            }
            res.add(right - left + 1);
            left = right+1;
            right = left ;
        }
        return res;
    }
}
