package cn.lee.leetcode.probolems.g3;

import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q374
 * @Description:
 * @author: libo
 * @date: 2020/9/22 12:42
 * @Version: 1.0
 */
@Slf4j
public class Q374 {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0)
                return mid;
            else if (res < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    int guess(int num) {

        return 1;
    }
}
