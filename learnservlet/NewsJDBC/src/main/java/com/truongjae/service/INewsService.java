package com.truongjae.service;

import java.util.List;

import com.truongjae.model.NewsModel;

public interface INewsService {
	List<NewsModel> findByCategoryId(Long categoryId);
	NewsModel save(NewsModel newsModel);
	NewsModel update(NewsModel newsModel);
	void delele(Long ids[]);
	List<NewsModel> findAll();
}
