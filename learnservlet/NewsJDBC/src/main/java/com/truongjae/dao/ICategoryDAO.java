package com.truongjae.dao;
import java.util.List;
import com.truongjae.model.CategoryModel;
public interface ICategoryDAO extends GenericDAO<CategoryModel>{
	List<CategoryModel> findAll();
}
