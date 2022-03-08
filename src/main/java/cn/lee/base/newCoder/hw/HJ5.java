package cn.lee.base.newCoder.hw;

import java.util.Scanner;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: HJ5
 * @Description:
 * @author: libo
 * @date: 2022/3/4 13:58
 * @Version: 1.0
 */
@Slf4j
public class HJ5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		int ans = 0, base = 1;
		for (int i = input.length() - 1; i >= 0; i--) {
			char c = input.charAt(i);
			c = Character.toLowerCase(c);
			System.out.println(c >= '0' && c <= '9');
			System.out.println(c >= 'a' && c <= 'f');
			int t = 0;
			if (c >= '0' && c <= '9') {
				t = c - '0';
			} else if (c >= 'a' && c <= 'f') {
				t = c - 'a';
			} else {
				break;
			}
			System.out.println(c - 'a');
			ans += t * base;
			base = base * 10;
		}
		System.out.println(ans);
	}
	@Test
	public void test_1(){
		System.out.println('a'-'a');
	}
}
