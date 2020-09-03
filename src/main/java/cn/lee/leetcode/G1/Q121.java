package cn.lee.leetcode.G1;import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**  
    * @Title: Q121
    * @Description: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
    * @author libo
    * @date 2020/9/3 11:02
    * @Version 1.0
    */
@Slf4j
public class Q121 {
    public static void main(String[] args) {
        Q121 q = new Q121();
        System.out.println(q.maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public int maxProfit(int[] prices) {
        int max=0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                max=max>prices[j]-prices[i]?max:prices[j]-prices[i];
            }
        }
        return max;
    }
}
