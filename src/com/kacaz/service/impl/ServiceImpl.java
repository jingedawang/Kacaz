package com.kacaz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kacaz.dao.EntityDao;
import com.kacaz.entity.Activity;
import com.kacaz.entity.User;
import com.kacaz.entity.Username;
import com.kacaz.service.Service;
@Transactional
@Repository(value="service")
public class ServiceImpl implements Service{
	@Resource
	private EntityDao entityDao;
	public boolean isUserExist(String username ){
		if(entityDao.findByProperty("weixin", username, new Username()).isEmpty())
		{
			return false;
		}else{
			return true;
		}
		
	}
	
	
	public boolean register(User user,Username username){
		if(entityDao.findByProperty("weixin", username.getWeixin(), new Username()).isEmpty())
		{
			
			entityDao.save(user);
			username.setUser(user);
			entityDao.save(username);
			return true;
		}
		else{
			return false;
		}
		
	}
	@Override
	public Username getUsernamebyWeixin(String weixin) {
		// TODO Auto-generated method stub
		return  (Username) entityDao.findByProperty("weixin", weixin, new Username()).get(0);
	}


	@Override
	public User getUserbyWeixin(String weixin) {
		// TODO Auto-generated method stub
		return  (User) entityDao.findByProperty("username.weixin", weixin, new User()).get(0);
	}
	
	@Override
	public User getUserbyId(String id) {
		// TODO Auto-generated method stub
		return  (User) entityDao.findByProperty("id", id, new User()).get(0);
	}

	@Override
	public boolean saveActivity(Activity activity) {
		// TODO Auto-generated method stub
		if(entityDao.save(activity)){
			return true;
		};
		return false;
	}
	

}
