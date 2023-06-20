package cn.lee.leetcode.probolems.g6;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: Q649
 * @Description: https://leetcode-cn.com/problems/dota2-senate/
 * @author: libo
 * @date: 2020/12/11 9:30
 * @Version: 1.0
 */
@Slf4j
public class Q649 {
    @Test
    public void test1() {
        Assert.assertEquals("Radiant", predictPartyVictory("RD"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("Dire", predictPartyVictory("RDD"));
    }

    @Test
    public void test3() {
        Assert.assertEquals("Dire", predictPartyVictory("DDRRR"));
    }

    @Test
    public void test4() {
        Assert.assertEquals("Radiant", predictPartyVictory("DRRR"));
    }

    @Test
    public void test5() {
        Assert.assertEquals("Radiant", predictPartyVictory("DRRDRDRDRDDRDRDR"));
    }


    public String predictPartyVictory(String senate) {
        List<Integer> r = new ArrayList<>();
        List<Integer> d = new ArrayList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                r.add(i);
            } else {
                d.add(i);
            }
        }
        int[] pos = new int[senate.length()];
        while (r.size() > 0 && d.size() > 0) {
            for (int i = 0; i < senate.length(); i++) {
                if (r.size() == 0 || d.size() == 0) {
                    break;
                }
                char c = senate.charAt(i);
                if (pos[i] == 1) {
                    continue;
                }
                if (c == 'R') {
                    pos[d.get(0)] = 1;
                    d.remove(0);
                } else {
                    pos[r.get(0)] = 1;
                    r.remove(0);
                }
            }
        }


        return d.size() == 0 ? "Radiant" : "Dire";
    }
}
