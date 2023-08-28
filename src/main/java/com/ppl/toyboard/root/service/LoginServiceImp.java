package com.ppl.toyboard.root.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppl.toyboard.root.dao.LoginDAO;
import com.ppl.toyboard.root.vo.UserVO;

@Service
public class LoginServiceImp implements LoginService {

	private LoginDAO loginDao;
	
	@Autowired
	public LoginServiceImp(LoginDAO loginDao) {
		this.loginDao = loginDao;
	}
	
	// 현재는 그냥 boolean으로 처리하는데 나중에 에러 코드 처리방법 배우면 다르게 구현할 것.
	@Override
	public boolean insertUser(UserVO user) {
		//validation 체크는 나중에 
		if(getUser(user)!=null) {
			return false;
		}
		loginDao.insertUser(user);
		return true;
	}
	
	@Override
	public UserVO getUser(UserVO user) {
		return loginDao.getUser(user);
	}
	
	@Override
	public boolean checkUser(UserVO user) {
		UserVO dbUser = loginDao.getUser(user);
		if(dbUser.equals(user)) {
			return true;
		}
		return false;
	}

	@Override
	public void deleteAllUser() {
		loginDao.deleteAllUser();
		
	}

	@Override
	public int countAllUser() {
		return loginDao.countAllUser();
	}

}
