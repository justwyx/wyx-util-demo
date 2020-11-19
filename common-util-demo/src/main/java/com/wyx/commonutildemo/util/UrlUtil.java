package com.wyx.commonutildemo.util;

import java.net.URLEncoder;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class UrlUtil {
    
    private static final Logger logger = LoggerFactory.getLogger(UrlUtil.class);
    
    /**
     * 长链接生成短链接
     * @param sourceUrl
     * @return
     */
    public static String changeLangLinkToShortLink(String sourceUrl) {
        String backStr = null;
        String weiboUrl = "https://api.t.sina.com.cn/short_url/shorten.json";
        String paramUrl = "source=2849184197&url_long=" + urlEnodeUTF8(sourceUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(weiboUrl);
        try {
            StringEntity s = new StringEntity(paramUrl);
            s.setContentEncoding("UTF-8");
            s.setContentType("application/x-www-form-urlencoded");
            post.setEntity(s);
            HttpResponse res = client.execute(post);
            if (res.getStatusLine().getStatusCode() == 200) {
                backStr = EntityUtils.toString(res.getEntity());
            }
        } catch (Exception e) {
            logger.error("==>> 长连接转换短链接异常{}", e);
        }

        if (StringUtils.isNotBlank(backStr)) {
            JSONObject jsonObj = JSON.parseObject(backStr);
            JSONArray urls_JsonArray = jsonObj.containsKey("urls") ? jsonObj.getJSONArray("urls") : null;
            if (urls_JsonArray == null) {
                return sourceUrl;
            }

            if (urls_JsonArray.size() > 0) {
                JSONObject inner_JsonObj = urls_JsonArray.getJSONObject(0);
                String url_short = inner_JsonObj.containsKey("url_short") ? inner_JsonObj.get("url_short").toString() : null;

                if (url_short == null) {
                    return sourceUrl;
                }

                return url_short;
            }
        }
        return sourceUrl;
    }

    public static String urlEnodeUTF8(String str) {
        String result = str;
        try {
            result = URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(changeLangLinkToShortLink("http://admin.nanjingsaas.cn:8080/admin/supplyCloudApply"));
    }
}
