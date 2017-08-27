package com.kacaz.junit.daotest;

import com.kacaz.config.MyConfig;
import com.kacaz.http.HttpRequestor;
import com.qq.weixin.mp.aes.Signature;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String aaaa = Signature.getSignature("dfaf", Signature.getTimeStamp(), Signature.getRandomStr());
			System.out.println(aaaa);
//			String aaa = (new HttpRequestor()).doGet(MyConfig.GET_WEIXIX+"aaa");
//			System.out.println(aaa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
