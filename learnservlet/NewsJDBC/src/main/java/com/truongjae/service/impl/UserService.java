package com.truongjae.service.impl;

import javax.inject.Inject;

import com.truongjae.dao.IUserDAO;
import com.truongjae.model.UserModel;
import com.truongjae.service.IUserService;

public class UserService implements IUserService{
	
	@Inject
	private IUserDAO iUserDAO;
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String username, String password, Integer status) {
		return iUserDAO.findByUserNameAndPasswordAndStatus(username, password, status);
	}

}
