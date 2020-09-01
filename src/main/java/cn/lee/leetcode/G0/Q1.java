package cn.lee.leetcode.G0;import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**  
    * @Title: Q1
    * @Description: 
    * @author libo
    * @date 2020/8/27 15:34
    * @Version 1.0
    */
@Slf4j
public class Q1 {
    public static void main(String[] args) {

    }
    public static int[] twoSum(int[] nums, int target) {
        int [] res = new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                    break;
                }
            }
        }
        return res;
    }
}
