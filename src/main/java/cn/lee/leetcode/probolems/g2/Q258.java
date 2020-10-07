package cn.lee.leetcode.probolems.g2;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**  
    * @Title: Q258
    * @Description: https://leetcode-cn.com/problems/add-digits/
    * @author: libo
    * @date: 2020/9/25 10:29
    * @Version: 1.0
    */
@Slf4j
public class Q258 {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
