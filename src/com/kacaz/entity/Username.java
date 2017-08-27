package com.kacaz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Username {
	
	private Integer id;
	private String kacazName;
	private String Weixin;
	private String weibo;
	private User user;
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getKacazName() {
		return kacazName;
	}
	public void setKacazName(String kacazName) {
		this.kacazName = kacazName;
	}
	public String getWeixin() {
		return Weixin;
	}
	public void setWeixin(String weixin) {
		Weixin = weixin;
	}
	public String getWeibo() {
		return weibo;
	}
	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}
	
	@OneToOne  
    @JoinColumn(insertable=true, unique=true)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
