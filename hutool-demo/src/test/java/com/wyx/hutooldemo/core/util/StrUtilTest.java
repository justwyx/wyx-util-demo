package com.wyx.hutooldemo.core.util;

import cn.hutool.core.util.StrUtil;
import org.junit.jupiter.api.Test;

/**
 * @author : Just wyx
 * @Date : 2020/12/15
 */
public class StrUtilTest {
	@Test
	public void test() {
		String token = "platformUser.login.token_prefix:b3c9e5f4-4906-4f3c-996a-852bd2f3bd17";
		System.out.println(StrUtil.isBlankOrUndefined(token));
	}
}
