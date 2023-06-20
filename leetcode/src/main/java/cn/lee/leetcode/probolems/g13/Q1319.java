package cn.lee.leetcode.probolems.g13;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: Q1319
 * @Description:
 * @author: libo
 * @date: 2021/1/23 19:41
 * @Version: 1.0
 */
@Slf4j
public class Q1319 {

    @Test
    public void test1() {
        Assert.assertEquals(1, makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(-1, makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}}));
    }

    @Test
    public void test4() {
        Assert.assertEquals(0, makeConnected(5, new int[][]{{0, 1}, {0, 2}, {3, 4}, {2, 3}}));
    }


    List<Integer>[] edges;
    boolean[] used;

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        edges = new List[n];
        for (int i = 0; i < n; ++i) {
            edges[i] = new ArrayList<Integer>();
        }
        for (int[] conn : connections) {
            edges[conn[0]].add(conn[1]);
            edges[conn[1]].add(conn[0]);
        }

        used = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (!used[i]) {
                dfs(i);
                ++ans;
            }
        }

        return ans - 1;
    }

    public void dfs(int u) {
        used[u] = true;
        for (int v : edges[u]) {
            if (!used[v]) {
                dfs(v);
            }
        }
    }

    public int makeConnected2(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        Map<Integer, Integer> pos = new HashMap<>();
        Map<Integer, List<Integer>> join = new HashMap<>();
        for (int i = 0; i < connections.length; i++) {
            int[] connection = connections[i];
            if (pos.containsKey(connection[0])) {

            }
        }
        return join.values().size();
    }
}
