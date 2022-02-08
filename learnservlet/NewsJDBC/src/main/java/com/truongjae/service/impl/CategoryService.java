package com.truongjae.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.truongjae.dao.ICategoryDAO;
import com.truongjae.dao.impl.CategoryDAO;
import com.truongjae.model.CategoryModel;
import com.truongjae.service.ICategoryService;

public class CategoryService implements ICategoryService{
//	private ICategoryDAO iCategoryDAO;
//	public CategoryService() {
//		iCategoryDAO = new CategoryDAO();
//	}
	@Inject
	private ICategoryDAO iCategoryDAO;
	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		return iCategoryDAO.findAll();
	}
	
}
