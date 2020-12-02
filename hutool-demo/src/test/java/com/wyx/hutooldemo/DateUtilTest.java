package com.wyx.hutooldemo;

import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author : Just wyx
 * @Date : 2020/12/1
 */
public class DateUtilTest {
	@Test
	public void test() {
		System.out.println("当前时间的毫秒数" + new Date().getTime());
		System.out.println("当前时间的毫秒数加5分钟" + (new Date().getTime() + 5 * 60 * 1000));
	}
}
