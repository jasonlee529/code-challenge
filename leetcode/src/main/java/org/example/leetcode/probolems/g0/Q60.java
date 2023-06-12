package org.example.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Title: Q60
 * @Description:
 * @author: libo
 * @date: 2020/9/5 22:45
 * @Version: 1.0
 */
@Slf4j
public class Q60 {
    public static void main(String[] args) {
        Q60 q = new Q60();
        System.out.println(q.getPermutation(3, 3));

    }

    public String getPermutation(int n, int k) {
        int[] fact = new int[n + 1];
        boolean[] st = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();
        fact[0] = fact[1] = 1;
        for (int i = 2; i <= n; i++) fact[i] = fact[i - 1] * i;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!st[j]) {
                    if (k <= fact[n - i]) {
                        sb.append(j);
                        st[j] = true;
                        break;
                    }
                    k -= fact[n - i];
                }
            }
        }
        return sb.toString();

    }

    public String getPermutation2(int n, int k) {
        List<String> stringList = getN(n);
        Collections.sort(stringList);
        return stringList.get(k - 1);
    }

    private List<String> getN(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0) {

            }
        }
        return new ArrayList<>();
    }
}
