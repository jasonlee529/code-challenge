package cn.lee.leetcode.g3;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @Title: Q347
 * @Description: https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @author: libo
 * @date: 2020/9/7 13:47
 * @Version: 1.0
 */
@Slf4j
public class Q347 {
    public static void main(String[] args) {
        System.out.println(new Q347().topKFrequent(new int[]{1,1,1,2,2,3},2));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i])==null){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        List<Map.Entry<Integer,Integer>> set = new ArrayList(map.entrySet());
        Collections.sort(set, new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        int []r = new int[k];
        for(int i=0;i<k;i++){
            r[i]=set.get(i).getKey();
        }
        return r;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        int[] arr = new int[Integer.MAX_VALUE];
        for (int i : nums) {
            arr[nums[i]] += 1;
        }
        Map<Integer, List<Integer>> res = new HashMap<>();
        for (int i = 1; i < arr.length; i++) {
            Integer m = arr[i];
            if (m == 0) {
                continue;
            }
            if (res.get(Integer.valueOf(m)) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
            }
            res.get(m).add(i);
        }
        Arrays.sort(arr);
        List<Integer> r = new ArrayList<>();
        for (int i : arr) {
            r.addAll(res.get(Integer.valueOf(i)));
            if (r.size() >= k) {
                break;
            }
        }
        int[] t = new int[r.size()];
        for (int i = 0; i < r.size(); i++) {
            t[i] = r.get(i);
        }
        return t;
    }
}
