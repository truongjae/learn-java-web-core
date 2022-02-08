package com.truongjae.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.truongjae.model.NewsModel;

public class NewsMapper implements RowMapper<NewsModel>{

	@Override
	public NewsModel mapRow(ResultSet rs) {
		try {
			NewsModel newsModel = new NewsModel();
			newsModel.setId(rs.getLong("id"));
			newsModel.setTilte(rs.getString("title"));
			newsModel.setContent(rs.getString("content"));
			newsModel.setCategoryId(rs.getLong("categoryid"));
			newsModel.setThumbnail(rs.getString("thumbnail"));
			newsModel.setShortDescription(rs.getString("shortdescription"));
			newsModel.setCreatedBy(rs.getString("createdby"));
			newsModel.setCreatedDate(rs.getTimestamp("createddate"));
			return newsModel;
		} catch (SQLException e) {
			return null;
		}
	}

}
