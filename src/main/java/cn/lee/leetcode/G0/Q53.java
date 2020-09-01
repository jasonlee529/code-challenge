package cn.lee.leetcode.G0;import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**  
    * @Title: Q53
    * @Description: https://leetcode-cn.com/problems/maximum-subarray
    * @author libo
    * @date 2020/9/1 19:33
    * @Version 1.0
    */
@Slf4j
public class Q53 {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {

        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;

    }
}
