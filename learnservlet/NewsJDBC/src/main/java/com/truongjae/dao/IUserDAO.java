package com.truongjae.dao;

import com.truongjae.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
	UserModel findByUserNameAndPasswordAndStatus(String username,String password,Integer status);
}
