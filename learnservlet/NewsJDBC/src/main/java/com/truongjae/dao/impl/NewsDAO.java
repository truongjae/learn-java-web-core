package com.truongjae.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import com.truongjae.dao.INewsDAO;
import com.truongjae.mapper.NewsMapper;
import com.truongjae.model.NewsModel;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		String sql = "select * from news where categoryid = ?";
		return query(sql, new NewsMapper(), categoryId);
	}

	@Override
	public Long save(NewsModel newsModel) {
		StringBuilder sql = new StringBuilder("insert into news (title,content,categoryid,");
		sql.append("thumbnail,shortdescription,createddate,createdby)");
		sql.append(" values(?,?,?,?,?,?,?)");
		return insert(sql.toString(), newsModel.getTitle(),newsModel.getContent(),newsModel.getCategoryId(),
				newsModel.getThumbnail(),newsModel.getShortDescription(),newsModel.getCreatedDate(),newsModel.getCreatedBy());
	}

	@Override
	public NewsModel findOne(Long id) {
		String sql = "select * from news where id = ?";
		List<NewsModel> newsModel = query(sql,new NewsMapper(),id);
		return newsModel.isEmpty() ? null : newsModel.get(0);
	}

	@Override
	public void update(NewsModel newsModel) {
		StringBuilder sql = new StringBuilder("update news set ");
		sql.append("title=?, content=?, thumbnail=?, shortdescription=?, categoryid=?, ");
		sql.append("createdby=?, createddate=?, modifieddate=?,modifiedby=? where id=?");
		update(sql.toString(),newsModel.getTitle(),newsModel.getContent(),newsModel.getThumbnail(),
				newsModel.getShortDescription(),newsModel.getCategoryId(),newsModel.getCreatedBy(),
				newsModel.getCreatedDate(),newsModel.getModifiedDate(),newsModel.getModifiedBy(),newsModel.getId());
	}
	
	public void queryDelete(Long[] ids,String table,String idField) {
		StringBuilder sql = new StringBuilder("delete from ");
		sql.append(table);
		sql.append(" where ");
		sql.append(idField);
		sql.append(" in(");
		for(long id : ids) {
			sql.append("?,");
		}
		sql.deleteCharAt(sql.length()-1);
		sql.append(")");
		update(sql.toString(),ids);
	}
	@Override
	public void delete(Long[] ids) {
		/*StringBuilder sql = new StringBuilder("delete from news where id in(");
		for(long id : ids) {
			sql.append("?,");
		}
		sql.deleteCharAt(sql.length()-1);
		sql.append(")");
		update(sql.toString(),ids);*/
		queryDelete(ids, "comment", "newsid");
		queryDelete(ids, "news", "id");
		
	}

	@Override
	public List<NewsModel> findAll() {
		String sql = "select * from news";
		return query(sql, new NewsMapper());
	}

	
}
