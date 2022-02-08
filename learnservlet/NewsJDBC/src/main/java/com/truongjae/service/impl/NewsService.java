package com.truongjae.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.truongjae.dao.INewsDAO;
import com.truongjae.model.NewsModel;
import com.truongjae.service.INewsService;

public class NewsService implements INewsService{
	@Inject
	private INewsDAO iNewsDAO;
	public List<NewsModel> findByCategoryId(Long categoryId){
		return iNewsDAO.findByCategoryId(categoryId);
	}
	@Override
	public NewsModel save(NewsModel newsModel) {
		newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newsModel.setCreatedBy("");
		Long id =  iNewsDAO.save(newsModel);
		return iNewsDAO.findOne(id);
	}
	@Override
	public NewsModel update(NewsModel newsModel) {
		NewsModel oldNews = iNewsDAO.findOne(newsModel.getId());
		newsModel.setCreatedDate(oldNews.getCreatedDate());
		newsModel.setCreatedBy(oldNews.getCreatedBy());
		newsModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		newsModel.setModifiedBy("");
		iNewsDAO.update(newsModel);
		return iNewsDAO.findOne(newsModel.getId());
	}
	@Override
	public void delele(Long[] ids) {
		iNewsDAO.delete(ids);
	}
	@Override
	public List<NewsModel> findAll() {
		return iNewsDAO.findAll();
	}

	
}
