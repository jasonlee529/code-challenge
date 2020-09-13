package cn.lee.leetcode.probolems.g3;

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
        System.out.println(Arrays.toString(new Q347().topKFrequent( new int[]{1,1,1,2,2,3},2)));
        System.out.println(Arrays.toString(new Q347().topKFrequent1( new int[]{1,1,1,2,2,3},2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }
    public int[] topKFrequent1(int[] nums, int k) {
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
}
