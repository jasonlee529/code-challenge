package org.example.leetcode.probolems.g15;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author libo
 * @Title: Q1561
 * @Description: https://leetcode-cn.com/contest/weekly-contest-203/problems/maximum-number-of-coins-you-can-get/
 * @date 2020/8/28 16:13
 * @Version 1.0
 */
@Slf4j
public class Q1561 {
    public static void main(String[] args) {
        maxCoins(new int[]{2, 4, 1, 2, 7, 8});
        maxCoins(new int[]{2, 4, 5});
        maxCoins(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4});

    }

    public static int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int max = 0;
        for (int i = piles.length / 3; i < piles.length; i = i + 2) {
            max = max += piles[i];
        }
        System.out.println(max);
        return max;
//        System.out.println(findLast(piles,new int[piles.length],piles.length,0));
    }

    static int findLast(int[] piles, int[] pos, int r, int max) {
        if (r == 0) {
            return max;
        }
        for (int j = 0; j < piles.length; j++) {
            for (int k = j + 1; k < piles.length; k++) {
                for (int l = k + 1; l < piles.length; l++) {
                    if (pos[j] == 0 && pos[k] == 0 && pos[l] == 0) {
                        pos[j] = 1;
                        pos[k] = 1;
                        pos[l] = 1;
                        int t = findMid(piles[j], piles[k], piles[l]);
                        System.out.println(String.format("%d,%d,%d,%d", piles[j], piles[k], piles[l], t));
                        r = r - 3;
                        max = max + t;
                        findLast(piles, pos, r, max);
                    }
                }
            }
        }
        return 0;
    }

    private static int findMid(int pile, int pile1, int pile2) {
        List<Integer> list = new ArrayList<>();
        list.add(pile);
        list.add(pile1);
        list.add(pile2);
        Collections.sort(list);
        return list.get(1);
    }
}
