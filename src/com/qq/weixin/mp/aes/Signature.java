package com.qq.weixin.mp.aes;

import java.util.Random;

import com.alibaba.fastjson.JSON;
import com.kacaz.config.MyConfig;
import com.kacaz.http.HttpRequestor;

public class Signature {
	
	public static String getTimeStamp(){
		return Long.toString(System.currentTimeMillis());
	}
	public static String getSignature(String url, String timeStamp, String nonce) throws AesException {
		// 加密
//		String encrypt = encrypt(getRandomStr(), replyMsg);
		String token = null;
		try {
			token = (new HttpRequestor()).doGet(MyConfig.GET_TOEN);
			token = (new HttpRequestor()).doGet(MyConfig.GET_JSAPI_TICKET+token);
			token = JSON.parseObject(token).getString("ticket");
			System.out.println(token+"这是token");
//			System.out.println(token+"这是token");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 生成安全签名
		if (timeStamp == "") {
			timeStamp = Long.toString(System.currentTimeMillis());
		}

		String signature = SHA1.getSHA1(token, timeStamp, nonce, url);

		// System.out.println("发送给平台的签名是: " + signature[1].toString());
		// 生成发送的xml
//		String result = XMLParse.generate(encrypt, signature, timeStamp, nonce);
		return signature;
	}
	public static String getRandomStr() {
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 16; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
}
