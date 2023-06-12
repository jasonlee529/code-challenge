package org.example.leetcode.weekly.w218;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q5617
 * @Description: https://leetcode-cn.com/contest/weekly-contest-218/problems/goal-parser-interpretation/
 * @author: libo
 * @date: 2020/12/6 10:31
 * @Version: 1.0
 */
@Slf4j
public class Q5617 {
    @Test
    public void test() {
        Assert.assertEquals("Goal", interpret("G()(al)"));
        Assert.assertEquals("Gooooal", interpret("G()()()()(al)"));
        Assert.assertEquals("alGalooG", interpret("(al)G(al)()()G"));
    }

    public String interpret(String command) {
        command=command.replaceAll("\\(\\)","o");
        command=command.replaceAll("\\(al\\)","al");
        return command;
    }
}
