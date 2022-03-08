package cn.lee.base.newCoder.hw;

import java.util.Scanner;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: HJ4
 * @Description:
 * @author: libo
 * @date: 2022/3/4 13:43
 * @Version: 1.0
 */
@Slf4j
public class HJ4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		while (input.length() > 8) {
			String str = input.substring(0, 8);
			input=input.substring(8);
			System.out.println(str);
		}
		if (input.length() > 0) {
			for (int i = input.length(); i < 8; i++) {
				input += "0";
			}
			System.out.println(input);
		}

	}
}
