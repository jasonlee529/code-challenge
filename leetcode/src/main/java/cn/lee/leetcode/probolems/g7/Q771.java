package cn.lee.leetcode.probolems.g7;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Title: Q771
 * @Description:
 * @author: libo
 * @date: 2023/7/24 0024 22:06
 * @Version: 1.0
 */
@Slf4j
public class Q771 {

    public static void main(String[] args) {
        Q771 q = new Q771();
        Assert.assertEquals(3, q.numJewelsInStones("aA", "aAAbbbb"));
        Assert.assertEquals(0, q.numJewelsInStones("z", "ZZ"));
    }

    public int numJewelsInStones(String jewels, String stones) {
        int jewelsCount = 0;
        Set<Character> jewelsSet = new HashSet<Character>();
        int jewelsLength = jewels.length(), stonesLength = stones.length();
        for (int i = 0; i < jewelsLength; i++) {
            char jewel = jewels.charAt(i);
            jewelsSet.add(jewel);
        }
        for (int i = 0; i < stonesLength; i++) {
            char stone = stones.charAt(i);
            if (jewelsSet.contains(stone)) {
                jewelsCount++;
            }
        }
        return jewelsCount;

    }
}