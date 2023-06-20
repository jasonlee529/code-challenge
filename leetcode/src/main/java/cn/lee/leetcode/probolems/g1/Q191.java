package cn.lee.leetcode.probolems.g1;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**  
    * @Title: Q191
    * @Description: https://leetcode-cn.com/problems/number-of-1-bits/submissions/
    * @author: libo
    * @date: 2021/3/22 13:53
    * @Version: 1.0
    */
@Slf4j
public class Q191 {
	public int hammingWeight(int n) {
		int sum = 0;
		while (n != 0) {
			sum++;
			n &= (n - 1);
		}
		return sum;
	}

}
