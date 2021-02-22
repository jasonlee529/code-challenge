package cn.lee.leetcode.probolems.g14;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Title: Q1436
 * @Description: https://leetcode-cn.com/problems/destination-city/
 * @author: libo
 * @date: 2021/1/5 22:46
 * @Version: 1.0
 */
@Slf4j
public class Q1436 {

    @Test
    public void test1() {
        Assert.assertEquals("", destCity(Arrays.asList(Arrays.asList("London", "New York"), Arrays.asList("New York", "Lima"),
                Arrays.asList("Lima", "Sao Paulo"))));
    }

    public String destCity(List<List<String>> paths) {
        return "";
    }
}
