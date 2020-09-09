package cn.lee.leetcode.g0;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title: Q39
 * @Description: https://leetcode-cn.com/problems/combination-sum/
 * @author: libo
 * @date: 2020/9/9 13:27
 * @Version: 1.0
 */
@Slf4j
public class Q39 {
    public static void main(String[] args) {
//        System.out.println(new Q39().combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(new Q39().combinationSum(new int[]{8,7,4,3}, 11));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> arr = new ArrayList<>();
        Deque<Integer> que = new LinkedList<>();
        dfs(candidates, target,0, que, arr);
        return arr;
    }

    private void dfs(int[] candidates, int target,int begin, Deque<Integer> que, List<List<Integer>> arr) {
        int sum =sum(que);
        if ( sum== target) {
            arr.add(new ArrayList<>(que));
            return;
        }else if(sum>target){
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                System.out.println(sum+candidates[i]);
               continue;
            }
            que.add(candidates[i]);
            dfs(candidates,target,i,que,arr);
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
