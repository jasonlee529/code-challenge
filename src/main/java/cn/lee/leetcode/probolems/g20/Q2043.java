package cn.lee.leetcode.probolems.g20;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q2043
 * @Description: https://leetcode-cn.com/problems/simple-bank-system/
 * @author: libo
 * @date: 2022/3/18 0018 0:37
 * @Version: 1.0
 */
@Slf4j
public class Q2043 {
    private long[] balance = null;

    public Q2043() {

    }

    public static Q2043 build(long[] balance) {
        Q2043 q = new Q2043();
        q.balance = balance;
        return q;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 <= balance.length && account2 <= balance.length && balance[account1 - 1] >= money) {
            balance[account1 - 1] -= money;
            balance[account2 - 1] += money;
            return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if (account <= balance.length) {
            balance[account - 1] += money;
            return true;
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        if (account <= balance.length && balance[account - 1] >= money) {
            balance[account - 1] -= money;
            return true;
        }
        return false;
    }

    Q2043 q = null;

    @Before
    public void before() {
        q = build(new long[]{10, 100, 20, 50, 30});
    }

    @Test
    public void test_1() {
        Assert.assertEquals(true, q.withdraw(3, 10));
        Assert.assertEquals(true, q.transfer(5, 1, 20));
        Assert.assertEquals(true, q.deposit(5, 20));
        Assert.assertEquals(false, q.transfer(3, 4, 15));
        Assert.assertEquals(false, q.withdraw(10, 50));
    }
}