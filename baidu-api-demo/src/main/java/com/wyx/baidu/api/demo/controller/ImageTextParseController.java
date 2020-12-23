package com.wyx.baidu.api.demo.controller;

import com.wyx.baidu.api.demo.service.AccurateBasic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author : Just wyx
 * @Date : 2020/12/23
 */
@RestController
@RequestMapping("/image/text/parse")
public class ImageTextParseController {

	@Resource
	private AccurateBasic accurateBasic;

	/**
	 * (what) : 解析图片中的文字
	 * (why) :
	 * (how) :
	 * @param file 入参
	 * @Author : Just wyx
	 * @Date : 13:38 2020/12/23
	 * @return : java.lang.String
	 */
	@PostMapping
	public String imageUpload(@RequestParam("file") MultipartFile file) {
		return accurateBasic.accurateBasic(file);
	}
}
