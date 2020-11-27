package com.wyx.commonutildemo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Just wyx
 * @Date : 2020/11/27
 */
public class Parent {
	private String name;
	private Integer age;

	public Parent() {
	}

	public Parent(Parent parent) {
		this.name = parent.getName();
		this.age = parent.getAge();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Parent{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	public static void main(String[] args) {
		List<Integer> idList = new ArrayList<>();
		List<String> collect = idList.stream().map(s -> s + "").collect(Collectors.toList());
		System.out.println(collect);
	}
}
