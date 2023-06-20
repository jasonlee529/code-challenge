package cn.lee.leetcode.weekly.w218;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * @Title: Q5620
 * @Description: https://leetcode-cn.com/contest/weekly-contest-218/problems/concatenation-of-consecutive-binary-numbers/
 * @author: libo
 * @date: 2020/12/6 10:46
 * @Version: 1.0
 */
@Slf4j
public class Q5620 {
    @Test
    public void test() {
        Assert.assertEquals(1, concatenatedBinary(1));
        Assert.assertEquals(27, concatenatedBinary(3));
        Assert.assertEquals(505379714, concatenatedBinary(12));
    }

    public int concatenatedBinary(int n) {


        return 0;
    }

    public int concatenatedBinary2(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            StringBuilder s2 = new StringBuilder();
            int m = i;
            while (m > 0) {
                s2.append(m % 2);
                m = m / 2;
            }
            sb.append(s2.reverse());
        }
        String str = sb.toString();
        BigInteger bigInteger = BigInteger.valueOf(0l);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                bigInteger = bigInteger.multiply(BigInteger.valueOf(2l)).add(BigInteger.valueOf(1l));
            } else {
                bigInteger = bigInteger.multiply(BigInteger.valueOf(2l));
            }
        }
        bigInteger = bigInteger.mod(new BigInteger("1000000007"));
        return bigInteger.intValue();
    }
}
