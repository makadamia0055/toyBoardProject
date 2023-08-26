package com.ppl.toyboard.root.service;

import com.ppl.toyboard.root.dao.LoginDAO;
import com.ppl.toyboard.root.vo.UserVO;

public class LoginServiceImp implements LoginService {

	private LoginDAO loginDao;
	
	public LoginServiceImp(LoginDAO loginDao) {
		this.loginDao = loginDao;
	}
	
	@Override
	public void insertUser(UserVO user) {
		loginDao.insertUser(user);
	}
	
	@Override
	public boolean checkUserVO(UserVO user) {
		UserVO dbUser = loginDao.getUser(user);
		if(dbUser.equals(user)) {
			return true;
		}
		return false;
	}

}
