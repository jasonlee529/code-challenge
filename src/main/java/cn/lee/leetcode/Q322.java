package cn.lee.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
    * @Title: Q322
    * @Description:  https://leetcode-cn.com/problems/reconstruct-itinerary/
    * @author libo
    * @date 2020/8/27 13:54
    * @Version 1.0
    */
@Slf4j
public class Q322 {
    public static void main(String[] args) {
        List<List<String>> inputs = Arrays.asList( Arrays.asList("JFK","SFO"), Arrays.asList("JFK","ATL"),
                Arrays.asList("SFO","ATL"),Arrays.asList("ATL","JFK"),
                Arrays.asList("ATL","SFO"));
        System.out.print(findItinerary(inputs));
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        // 因为逆序插入，所以用链表
        List<String> ans = new LinkedList<>();
        if (tickets == null || tickets.size() == 0)
            return ans;
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> pair : tickets) {
            // 因为涉及删除操作，我们用链表
            PriorityQueue<String> nbr = graph.computeIfAbsent(pair.get(0), k -> new PriorityQueue<>());
            nbr.add(pair.get(1));
        }
        visit(graph, "JFK", ans);
        return ans;
    }
    // DFS方式遍历图，当走到不能走为止，再将节点加入到答案
    private static void visit(Map<String, PriorityQueue<String>> graph, String src, List<String> ans) {
        PriorityQueue<String> nbr = graph.get(src);
        while (nbr != null && nbr.size() > 0) {
            String dest = nbr.poll();
            visit(graph, dest, ans);
        }
        ans.add(0, src); // 逆序插入
    }

}
