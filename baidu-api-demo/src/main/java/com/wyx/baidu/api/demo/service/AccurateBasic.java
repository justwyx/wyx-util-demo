package com.wyx.baidu.api.demo.service;

/**
 * @author : Just wyx
 * @Date : 2020/12/22
 */
import com.wyx.baidu.api.demo.util.Base64Util;
import com.wyx.baidu.api.demo.util.FileUtil;
import com.wyx.baidu.api.demo.util.HttpUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLEncoder;

/**
 * 通用文字识别（高精度版）
 */
@Service
public class AccurateBasic {

	/**
	 * 重要提示代码中所需工具类
	 * FileUtil,Base64Util,HttpUtil,GsonUtils请从
	 * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
	 * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
	 * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
	 * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
	 * 下载
	 */
	public static String accurateBasic() {
		// 请求url
		String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate_basic";
		try {
			// 本地文件路径
//			String filePath = "/Users/JustWyx/Pictures/Wallpapers/海贼王0000-042.jpg";
			String filePath = "https://picture.china-iia.com/82a0290e-77c1-40e1-9b98-dd4197b00464";
			byte[] imgData = FileUtil.readFileByBytes(filePath);
			String imgStr = Base64Util.encode(imgData);
			String imgParam = URLEncoder.encode(imgStr, "UTF-8");

			String param = "image=" + imgParam;

			// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
			// 24.c899ee6a51466f1b85ceb9b61669ea15.2592000.1611286835.282335-23196895
			String accessToken = "24.8fe857ccf018eb909509456ecacb7d2c.2592000.1611225732.282335-23196895";

			// {"error_code":110,"error_msg":"Access token invalid or no longer valid"}
			// {"log_id": 1887160549816144215, "words_result_num": 3, "words_result": [{"words": "她说七武海啊"}, {"words": " QIY"}, {"words": "它们是不是去向老板报告你把秘密告诉我们这事了奇艺独播"}]}
			String result = HttpUtil.post(url, accessToken, param);
			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public static String accurateBasic(MultipartFile file) {
		// 请求url
		String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate_basic";
		try {
			byte[] imgData = file.getBytes();
			String imgStr = Base64Util.encode(imgData);
			String imgParam = URLEncoder.encode(imgStr, "UTF-8");

			String param = "image=" + imgParam;

			// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
			// 24.c899ee6a51466f1b85ceb9b61669ea15.2592000.1611286835.282335-23196895
			String accessToken = "24.8fe857ccf018eb909509456ecacb7d2c.2592000.1611225732.282335-23196895";

			// {"error_code":110,"error_msg":"Access token invalid or no longer valid"}
			// {"log_id": 1887160549816144215, "words_result_num": 3, "words_result": [{"words": "她说七武海啊"}, {"words": " QIY"}, {"words": "它们是不是去向老板报告你把秘密告诉我们这事了奇艺独播"}]}
			String result = HttpUtil.post(url, accessToken, param);
			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		AccurateBasic.accurateBasic();
	}
}
