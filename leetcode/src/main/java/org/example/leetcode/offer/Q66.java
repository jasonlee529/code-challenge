package org.example.leetcode.offer;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q66
 * @Description: https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 * @author: libo
 * @date: 2022/2/18 0018 6:58
 * @Version: 1.0
 */
@Slf4j
public class Q66 {

	public int[] constructArr(int[] a) {
		int[] b = new int[a.length];
		b[0] = 1;
		int tmp=1;
		for (int i = 1; i < a.length; i++) {
			b[i] = b[i - 1] * a[i - 1];
		}
		for(int i=a.length-2;i>=0;i--){
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
		return b;
	}

	@Test
	public void test_1() {
		Assert.assertArrayEquals(new int[]{120, 60, 40, 30, 24}, constructArr(new int[]{1, 2, 3, 4, 5}));
	}

}