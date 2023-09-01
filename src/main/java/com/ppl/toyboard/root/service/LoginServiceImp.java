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
	
	// ����� �׳� boolean���� ó���ϴµ� ���߿� ���� �ڵ� ó����� ���� �ٸ��� ������ ��.
	@Override
	public boolean insertUser(UserVO user) {
		//validation üũ�� ���߿� 
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
