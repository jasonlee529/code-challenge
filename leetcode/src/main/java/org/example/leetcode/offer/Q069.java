package org.example.leetcode.offer;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**  
    * @Title: Q069
    * @Description: https://leetcode-cn.com/problems/B1IidL/
    * @author: libo
    * @date: 2021/10/14 18:50
    * @Version: 1.0
    */
@Slf4j
public class Q069 {

	@Test
	public void test1(){
		Assert.assertEquals(1,peakIndexInMountainArray(new int[]{0,1,0}));
	}
	@Test
	public void test2(){
		Assert.assertEquals(2,peakIndexInMountainArray(new int[]{1,3,5,4,2}));
	}
	@Test
	public void test3(){
		Assert.assertEquals(1,peakIndexInMountainArray(new int[]{0,10,5,2}));
	}
	@Test
	public void test4(){
		Assert.assertEquals(2,peakIndexInMountainArray(new int[]{3,4,5,1}));
	}
	@Test
	public void test5(){
		Assert.assertEquals(2,peakIndexInMountainArray(new int[]{24,69,100,99,79,78,67,36,26,19}));
	}
	public int peakIndexInMountainArray(int[] arr) {


		return 0;
	}
}
