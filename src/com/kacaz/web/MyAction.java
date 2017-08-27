package com.kacaz.web;

//import java.net.URI;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;









//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kacaz.config.MyConfig;
import com.kacaz.entity.Activity;
import com.kacaz.entity.User;
import com.kacaz.entity.Username;
import com.kacaz.http.HttpRequestor;
import com.kacaz.service.Service;
import com.opensymphony.xwork2.ActionContext;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.Signature;
@Repository
public class MyAction {
	@Resource
	private Service service;
	private User user;
	private Username username;
	private String code;
	private Activity activity;
	private String date;
//	//js接口临时票据
//	private String jsapi_ticket;
	private String noncestr;
	private String timestamp;
	private String url;
	private String signature;
	
	public String registerUI(){
//		String weixin ;
		try {
			String weixin = (new HttpRequestor()).doGet(MyConfig.GET_WEIXIX+code);
			JSONObject j = JSON.parseObject(weixin);
			System.out.println("输出微信返回验证"+weixin);
			if(!j.containsKey("errcode")){
				if(j.containsKey("UserId"))
				{
					weixin = "userid"+j.getString("UserId");
					if(service.isUserExist(weixin))
						return "me";
					ActionContext.getContext().getSession().put("weixin",weixin);
					System.out.println(weixin);
				}
				/*if(j.containsKey("OpenId"))
				{
					weixin = "openid"+j.getString("OpenId");
					if(service.isUserExist(weixin))
						return "me";
					ActionContext.getContext().getSession().put("weixin", weixin);
					System.out.println(weixin);
				}*/
					
				return "register";//微信用户
			}else{
//				ActionContext.getContext().getSession().put("weixin", "userid2");
				ActionContext.getContext().getSession().put("fail", "不是微信用户");
				return "fail";//非微信用户
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionContext.getContext().getSession().put("fail", "RegisterUI异常");
		return "fail";//出错了
	}
	public String register(){
		/*user = new User();
		user.setNickname("hahah");
		username= new Username();
		username.setWeixin("aaaa");*/
		if(username.getWeixin()=="")
		{

			ActionContext.getContext().getSession().put("fail", "非微信用户，无法获取userID");
			return "fail";
		}
		if(service.register(user, username))
		{
			ActionContext.getContext().getSession().put("success", "注册成功");
			return "success";
		}else{
			ActionContext.getContext().getSession().put("fail", "注册失败用户已存在");
			return "fail";
		}
	}
	public String me(){
		try {
			//先获取个人userID
//			String 
//			ActionContext.getContext().getSession().get("")
			String weixin = (new HttpRequestor()).doGet(MyConfig.GET_WEIXIX+code);
			JSONObject j = JSON.parseObject(weixin);
			if(!j.containsKey("errcode")){
				if(j.containsKey("UserId"))
				{
					weixin = "userid"+j.getString("UserId");
					if(service.isUserExist(weixin))
					{
						user = service.getUserbyWeixin(weixin);
						username = service.getUsernamebyWeixin(weixin);
						return "me";
					}else{
						ActionContext.getContext().getSession().put("weixin", weixin);
						return "register";
					}
				}
//					ActionContext.getContext().getSession().put("weixin", "userid"+j.getString("UserId"));
				//判断是否注册用户
//					String userid = "userid"+j.getString("UserId");
				/*if(j.containsKey("OpenId"))
				{
					weixin = "openid"+j.getString("OpenId");
					if(service.isUserExist(weixin))
					{
						user = service.getUserbyWeixin(weixin);
						username = service.getUsernamebyWeixin(weixin);
						return "me";
					}else{
						ActionContext.getContext().getSession().put("weixin", weixin);
						return "register";
					}
				}	*/
					ActionContext.getContext().getSession().put("fail", "Me非微信用户");
				return "fail";
//					ActionContext.getContext().getSession().put("weixin", "openid"+j.getString("OpenId"));
					
			}else{
				ActionContext.getContext().getSession().put("fail", "Me未知错误");
				return "fail";//获取账户信息出错,跳转到注册页面
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "me";
	}
	public String create_activity(){
		try {
			//先获取个人userID
			
			
			String weixin = (new HttpRequestor()).doGet(MyConfig.GET_WEIXIX+code);
			JSONObject j = JSON.parseObject(weixin);
			if(!j.containsKey("errcode")){
				if(j.containsKey("UserId"))
				{
					weixin = "userid"+j.getString("UserId");
					if(service.isUserExist(weixin))
					{
						user = service.getUserbyWeixin(weixin);
//						username = service.getUsernamebyWeixin(weixin);
						return "create_activity";
					}else{
						ActionContext.getContext().getSession().put("weixin", weixin);
						return "register";
					}
				}
				//判断是否注册用户
				/*if(j.containsKey("OpenId"))
				{
					weixin = "openid"+j.getString("OpenId");
					if(service.isUserExist(weixin))
					{
						user = service.getUserbyWeixin(weixin);
//						username = service.getUsernamebyWeixin(weixin);
						return "create_activity";
					}else{
						ActionContext.getContext().getSession().put("weixin", weixin);
						return "register";
					}
				}	*/
					ActionContext.getContext().getSession().put("fail", "Me非微信用户");
				return "fail";
//					ActionContext.getContext().getSession().put("weixin", "openid"+j.getString("OpenId"));
					
			}else{
				ActionContext.getContext().getSession().put("fail", "Me未知错误");
				return "fail";//获取账户信息出错,跳转到注册页面
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "create_activity";
	}
	
	
	public String createActivity(){
		DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			date = date.replace('T', ' ');
			activity.setDate(dateFormat2.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user = service.getUserbyId(""+user.getId());
		System.out.println("时间："+activity.getDate());
		activity.setPromoter(user);
		if(service.saveActivity(activity)){
			ActionContext.getContext().getSession().put("success", "活动存储成功");
			return "success";
		}
		ActionContext.getContext().getSession().put("fail", "活动存储失败");
		return "fail";
	}
	public String home(){
		try {
			//先获取个人userID
			
			
			String weixin = (new HttpRequestor()).doGet(MyConfig.GET_WEIXIX+code);
			JSONObject j = JSON.parseObject(weixin);
			if(!j.containsKey("errcode")){
				if(j.containsKey("UserId"))
				{
					weixin = "userid"+j.getString("UserId");
					if(service.isUserExist(weixin))
					{
						user = service.getUserbyWeixin(weixin);
//						username = service.getUsernamebyWeixin(weixin);
						return "home";
					}else{
						ActionContext.getContext().getSession().put("weixin", weixin);
						return "register";
					}
				}
				//判断是否注册用户
				/*if(j.containsKey("OpenId"))
				{
					weixin = "openid"+j.getString("OpenId");
					if(service.isUserExist(weixin))
					{
						user = service.getUserbyWeixin(weixin);
//						username = service.getUsernamebyWeixin(weixin);
						return "create_activity";
					}else{
						ActionContext.getContext().getSession().put("weixin", weixin);
						return "register";
					}
				}	*/
					ActionContext.getContext().getSession().put("fail", "Me非微信用户");
				return "fail";
//					ActionContext.getContext().getSession().put("weixin", "openid"+j.getString("OpenId"));
					
			}else{
				ActionContext.getContext().getSession().put("fail", "Me未知错误");
				return "fail";//获取账户信息出错,跳转到注册页面
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "home";
	}
	
	
	
	
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Username getUsername() {
		return username;
	}
	public void setUsername(Username username) {
		this.username = username;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	public void setUrl(String actionname){
		url = MyConfig.BASE_URL+actionname+".do?code="+code+"&state=STATE";
	}
	
	
	
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public String getNoncestr() {
		return noncestr;
	}
	public void setNoncestr() {
		this.noncestr = Signature.getRandomStr();
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp() {
		this.timestamp = Signature.getTimeStamp();
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature() {
		try {
			this.signature = Signature.getSignature(url, timestamp, noncestr);
		} catch (AesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getDate() {
		return date;
	}
	public String getUrl() {
		return url;
	}
	
}
