package cn.lee.leetcode.g0;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**  
    * @Title: Q13
    * @Description: 
    * @author: libo
    * @date: 2020/9/4 14:01
    * @Version: 1.0
    */
@Slf4j
public class Q13 {
    public static void main(String[] args) {
        Q13 q = new Q13();
        System.out.println(q.romanToInt("I"));
    }
    public int romanToInt(String s) {
        int index=0;
        while(index<s.length()){
            while(s.charAt(index)=='I'){
                index++;
            }
        }

        return 0;
    }

}
