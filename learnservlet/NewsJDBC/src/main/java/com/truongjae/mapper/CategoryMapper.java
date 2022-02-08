package com.truongjae.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.truongjae.model.CategoryModel;
import com.truongjae.model.NewsModel;

public class CategoryMapper implements RowMapper<CategoryModel>{

	@Override
	public CategoryModel mapRow(ResultSet rs) {
		try {
			CategoryModel categoryModel = new CategoryModel();
			categoryModel.setId(rs.getLong("id"));
			categoryModel.setCode(rs.getString("code"));
			categoryModel.setName(rs.getString("name"));
			return categoryModel;
		} catch (SQLException e) {
			return null;
		}
	}
	
}
