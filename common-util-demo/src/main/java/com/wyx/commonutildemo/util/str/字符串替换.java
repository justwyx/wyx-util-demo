package com.wyx.commonutildemo.util.str;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Just wyx
 * @Date : 2020/11/25
 */
public class 字符串替换 {

	/**
	 * (what) : 占位符替换
	 * (why) :
	 * (how) :
	 * @param msg 入参
	 * @param value 入参
	 * @Author : Just wyx
	 * @Date : 18:19 2020/11/25
	 * @return : java.lang.String
	 */
	public static String replacePlaceholder(String msg, Map<String, String> value) {
		for (Map.Entry<String, String> entry : value.entrySet()) {
			msg = msg.replace("${" + entry.getKey() + "}", entry.getValue());
		}
		return msg;
	}

	public static void main(String[] args) {
		String str = "系统通知：您的订单号为${orderId}的订单已发货";
		Map<String, String> map = new HashMap<>();
		map.put("orderId", "123456");
		System.out.println(replacePlaceholder(str, map));
	}
}
