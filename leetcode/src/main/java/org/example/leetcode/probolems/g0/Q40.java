package org.example.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @Title: Q40
 * @Description: https://leetcode-cn.com/problems/combination-sum-ii/
 * @author: libo
 * @date: 2020/9/10 9:24
 * @Version: 1.0
 */
@Slf4j
public class Q40 {

    public static void main(String[] args) {
        System.out.println(new Q40().combinationSum2(new int[]{1,2,7,6,1,5},8));
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> arr = new HashSet<>();
        Deque<Integer> que = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(candidates, target,0, que, arr);
        return new ArrayList(arr);
    }

    private void dfs(int[] candidates, int target,int begin, Deque<Integer> que, Set<List<Integer>> arr) {
        int sum =sum(que);
        if ( sum== target) {
            arr.add(new ArrayList<>(que));
            return;
        }else if(sum>target){
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            que.add(candidates[i]);
            dfs(candidates,target,i+1,que,arr);
            que.removeLast();
        }
    }

    private int sum(Deque<Integer> que) {
        int sum = 0;
        for (Integer integer : que) {
            sum += integer;
        }
        return sum;
    }
   
}
