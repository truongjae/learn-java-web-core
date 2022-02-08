package com.truongjae.dao;

import java.util.List;

import com.truongjae.model.NewsModel;


public interface INewsDAO extends GenericDAO<NewsModel>{
	NewsModel findOne(Long id);
	List<NewsModel> findByCategoryId(Long categoryId);
	Long save(NewsModel newsModel);
	void update(NewsModel newsModel);
	void delete(Long[] ids);
	List<NewsModel> findAll();
}
