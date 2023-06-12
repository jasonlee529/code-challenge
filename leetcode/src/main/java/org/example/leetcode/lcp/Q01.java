package org.example.leetcode.lcp;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**  
    * @Title: Q01
    * @Description: https://leetcode-cn.com/problems/guess-numbers/
    * @author: libo
    * @date: 2020/9/23 14:00
    * @Version: 1.0
    */
@Slf4j
public class Q01 {
    public int game(int[] guess, int[] answer) {
        int cnt=0;
        for(int i=0;i<guess.length;i++){
            if(guess[i]==answer[i]){
                cnt++;
            }
        }
        return cnt;
    }
}
