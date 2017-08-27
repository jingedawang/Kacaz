package com.kacaz.http;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import com.kacaz.config.MyConfig;

public class HttpDownload {

	public static void main(String[] s){
		File file = new File("E:\\apache-tomcat-6.0.29\\webapps\\Upi\\WEB-INF\\upload.jpg");
		try {
			down(file,"https://qyapi.weixin.qq.com/cgi-bin/media/get?access_token="
					+ (new HttpRequestor()).doGet(MyConfig.GET_TOEN)
					+ "&media_id="
					+ "84bvtJ29dVPTOcLyprqfUwdZyJzXevo9WuauF3zp1nx-4g3TFT3-0D0WBG6x8fyb"
					/*+  (new HttpRequestor()).doGet(MyConfig.GET_TOEN)
					+ "&type="
					+ "TYPE"*/);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void down(File f, String imgUrl) {
        byte[] buffer = new byte[8 * 1024];
        URL u;
        URLConnection connection = null;
        try {
                u = new URL(imgUrl);
                connection = u.openConnection();
        } catch (Exception e) {
                System.out.println("ERR:" + imgUrl);
                return;
        }
        connection.setReadTimeout(100000);
        System.out.println("dfasdfa");
        InputStream is = null;
        FileOutputStream fos = null;
        try {
                f.createNewFile();
                is = connection.getInputStream();
                fos = new FileOutputStream(f);
                int len = 0;
                while ((len = is.read(buffer)) != -1) {
                        fos.write(buffer, 0, len);
                }

        } catch (Exception e) {
                f.delete();
        } finally {
                if (fos != null) {
                        try {
                                fos.close();
                        } catch (IOException e) {
                        }
                }
                if (is != null) {
                        try {
                                is.close();
                        } catch (IOException e) {
                        }
                }
        }
        buffer = null;
        // System.gc();
}
}
