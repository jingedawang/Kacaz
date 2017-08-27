package com.kacaz.service;

import com.kacaz.entity.Activity;
import com.kacaz.entity.User;
import com.kacaz.entity.Username;

public interface Service {
	public User getUserbyWeixin(String weixin);
	public Username getUsernamebyWeixin(String weixin);
	public boolean register(User user ,Username username);
	public boolean isUserExist(String username );
	public boolean saveActivity(Activity activity);
	public User getUserbyId(String id);
}
