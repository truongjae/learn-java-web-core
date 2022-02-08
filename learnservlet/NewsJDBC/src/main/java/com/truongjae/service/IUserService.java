package com.truongjae.service;

import com.truongjae.model.UserModel;

public interface IUserService {
	UserModel findByUserNameAndPasswordAndStatus(String username,String password,Integer status);
}
