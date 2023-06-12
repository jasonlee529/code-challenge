package org.example.leetcode.probolems.g16;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q1603
 * @Description: https://leetcode-cn.com/problems/design-parking-system/
 * @author: libo
 * @date: 2021/3/19 9:34
 * @Version: 1.0
 */
@Slf4j
public class Q1603 {

	@Test
	public void test1() {
		ParkingSystem ps = new ParkingSystem(1, 1, 0);
		Assert.assertTrue(ps.addCar(1));
		Assert.assertTrue(ps.addCar(2));
		Assert.assertFalse(ps.addCar(3));
		Assert.assertFalse(ps.addCar(1));
	}

	class ParkingSystem {
		int big = 0;
		int medium = 0;
		int small = 0;

		public ParkingSystem(int big, int medium, int small) {
			this.big = big;
			this.medium = medium;
			this.small = small;
		}

		public boolean addCar(int carType) {
			boolean ans = true;
			switch (carType) {
				case 1:
					ans = big > 0;
					big--;
					break;
				case 2:
					ans = medium > 0;
					medium--;
					break;
				case 3:
					ans = small > 0;
					small--;
					break;
				default:
					ans = false;
					break;
			}
			return ans;
		}
	}
}
