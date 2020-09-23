package cn.lee.leetcode.probolems.g2;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q231
 * @Description: https://leetcode-cn.com/problems/power-of-two/
 * @author: libo
 * @date: 2020/9/20 21:02
 * @Version: 1.0
 */
@Slf4j
public class Q231 {

    public boolean isPowerOfTwo(int n) {
        while (n != 0 ) {
           if(n%2!=0){
               return false;
           }
           n=n/2;
        }
        return true;
    }
}
