package cn.lee.base.lang;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: ConditionIf
 * @Description:
 * @author: libo
 * @date: 2022/3/2 15:27
 * @Version: 1.0
 */
@Slf4j
public class ConditionIf {
	@Test
	public void test_1() {
		int a = 3, b = 9;
		if (a == 3) {
			log.info("a==3,{}", a);
			b = 1;
		} else if ((b=1) < 2) {
			log.info("b<2,{}", b);
		} else {
			log.info("a<2,{}", a);
		}
	}
}
