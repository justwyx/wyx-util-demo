package com.wyx.baidu.api.demo.service;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 获取token类
 * @author : Just wyx
 * @Date : 2020/12/22
 */
public class AuthService {

	/**
	 * 获取权限token
	 * @return 返回示例：
	 * {
	 * "access_token": "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567",
	 * "expires_in": 2592000
	 * }
	 */
	public static String getAuth() {
		// 官网获取的 API Key 更新为你注册的
		String clientId = "百度云应用的AK";
		// 官网获取的 Secret Key 更新为你注册的
		String clientSecret = "百度云应用的SK";
		return getAuth(clientId, clientSecret);
	}

	/**
	 * 获取API访问token
	 * 该token有一定的有效期，需要自行管理，当失效时需重新获取.
	 * @param ak - 百度云官网获取的 API Key
	 * @param sk - 百度云官网获取的 Securet Key
	 * @return assess_token 示例：
	 * "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567"
	 */
	public static String getAuth(String ak, String sk) {
		// 获取token地址
		String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
		String getAccessTokenUrl = authHost
				// 1. grant_type为固定参数
				+ "grant_type=client_credentials"
				// 2. 官网获取的 API Key
				+ "&client_id=" + ak
				// 3. 官网获取的 Secret Key
				+ "&client_secret=" + sk;
		try {
			URL realUrl = new URL(getAccessTokenUrl);
			// 打开和URL之间的连接
			HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			// 获取所有响应头字段
//			Map<String, List<String>> map = connection.getHeaderFields();
//			// 遍历所有的响应头字段
//			for (String key : map.keySet()) {
//				System.err.println(key + "--->" + map.get(key));
//			}
			// 定义 BufferedReader输入流来读取URL的响应
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String result = "";
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			/**
			 * 返回结果示例
			 */
			// {"refresh_token":"25.1d6340f662d44923afa58b9788fb4675.315360000.1924064848.282335-23196895","expires_in":2592000,"session_key":"9mzdCrb26hYEzyFjtyoE3zSaCGXzg2mRLgYaJDsdNUujLhQsnhivRcCmuk9\/uZL3quPQkPahO1id9gonW9WxwK\/E2j1WBA==","access_token":"24.12b938a3ba928629c7877f647689cfd4.2592000.1611296848.282335-23196895","scope":"public vis-ocr_ocr vis-classify_dishes brain_ocr_scope vis-classify_car brain_ocr_general brain_ocr_general_basic vis-ocr_business_license brain_ocr_webimage brain_all_scope brain_ocr_idcard brain_ocr_driving_license brain_ocr_vehicle_license vis-ocr_plate_number vis-classify_animal vis-classify_plant brain_ocr_plate_number brain_ocr_accurate brain_ocr_accurate_basic brain_ocr_receipt brain_ocr_business_license brain_object_detect brain_realtime_logo brain_dish_detect brain_car_detect brain_animal_classify brain_plant_classify brain_solution_iocr brain_ingredient brain_qrcode brain_ocr_handwriting brain_ocr_passport brain_ocr_vat_invoice brain_advanced_general_classify brain_custom_dish brain_numbers brain_ocr_business_card brain_ocr_train_ticket brain_ocr_taxi_receipt vis-ocr_household_register vis-ocr_vis-classify_birth_certificate brain_poi_recognize vis-ocr_\u53f0\u6e7e\u901a\u884c\u8bc1 vis-ocr_\u6e2f\u6fb3\u901a\u884c\u8bc1 vis-ocr_\u673a\u52a8\u8f66\u8d2d\u8f66\u53d1\u7968\u8bc6\u522b vis-ocr_\u673a\u52a8\u8f66\u68c0\u9a8c\u5408\u683c\u8bc1\u8bc6\u522b vis-ocr_\u8f66\u8f86vin\u7801\u8bc6\u522b vis-ocr_\u5b9a\u989d\u53d1\u7968\u8bc6\u522b brain_vehicle_detect vis-ocr_\u4fdd\u5355\u8bc6\u522b vis-ocr_\u673a\u6253\u53d1\u7968\u8bc6\u522b vis-ocr_\u884c\u7a0b\u5355\u8bc6\u522b brain_redwine brain_ocr_vin brain_ocr_quota_invoice brain_ocr_birth_certificate brain_ocr_household_register brain_ocr_HK_Macau_pass brain_ocr_taiwan_pass brain_ocr_vehicle_invoice brain_ocr_vehicle_certificate brain_currency brain_vehicle_damage brain_ocr_air_ticket brain_ocr_invoice brain_ocr_insurance_doc brain_formula brain_ocr_facade brain_ocr_meter brain_doc_analysis brain_ocr_webimage_loc wise_adapt lebo_resource_base lightservice_public hetu_basic lightcms_map_poi kaidian_kaidian ApsMisTest_Test\u6743\u9650 vis-classify_flower lpq_\u5f00\u653e cop_helloScope ApsMis_fangdi_permission smartapp_snsapi_base smartapp_mapp_dev_manage iop_autocar oauth_tp_app smartapp_smart_game_openapi oauth_sessionkey smartapp_swanid_verify smartapp_opensource_openapi smartapp_opensource_recapi fake_face_detect_\u5f00\u653eScope vis-ocr_\u865a\u62df\u4eba\u7269\u52a9\u7406 idl-video_\u865a\u62df\u4eba\u7269\u52a9\u7406 smartapp_component smartapp_search_plugin","session_secret":"0e1df4d88be7b612d90749d2f7f6885e"}
			System.err.println("result:" + result);
			JSONObject jsonObject = new JSONObject(result);
			String access_token = jsonObject.getString("access_token");
			return access_token;
		} catch (Exception e) {
			System.err.printf("获取token失败！");
			e.printStackTrace(System.err);
		}
		return null;
	}

	public static void main(String[] args) {
		// 官网获取的 API Key 更新为你注册的
		String clientId = "FO0Bg7VMbCu0A3oI5GdAFwex";
		// 官网获取的 Secret Key 更新为你注册的
		String clientSecret = "T4htGuANNp1P9XPhTplf3exjfO913k8B";
		System.out.println(getAuth(clientId, clientSecret));
	}

}