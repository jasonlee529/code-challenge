package cn.lee.leetcode.probolems.g2;

import java.util.PriorityQueue;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q295
 * @Description: https://leetcode-cn.com/problems/find-median-from-data-stream/
 * @author: libo
 * @date: 2021/8/27 9:46
 * @Version: 1.0
 */
@Slf4j
public class Q295 {


	@Test
	public void test1() {
		MedianFinder finder = new MedianFinder();
		finder.addNum(1);
		finder.addNum(2);
		Assert.assertEquals(1.5, finder.findMedian(), 0.1);
		finder.addNum(3);
		Assert.assertEquals(2, finder.findMedian(), 0.1);

	}

	class MedianFinder {
		PriorityQueue<Integer> queMin;
		PriorityQueue<Integer> queMax;

		public MedianFinder() {
			queMin = new PriorityQueue<Integer>((a, b) -> (b - a));
			queMax = new PriorityQueue<Integer>((a, b) -> (a - b));
		}

		public void addNum(int num) {
			if (queMin.isEmpty() || num <= queMin.peek()) {
				queMin.offer(num);
				if (queMax.size() + 1 < queMin.size()) {
					queMax.offer(queMin.poll());
				}
			} else {
				queMax.offer(num);
				if (queMax.size() > queMin.size()) {
					queMin.offer(queMax.poll());
				}
			}
		}

		public double findMedian() {
			if (queMin.size() > queMax.size()) {
				return queMin.peek();
			}
			return (queMin.peek() + queMax.peek()) / 2.0;
		}
	}
}
