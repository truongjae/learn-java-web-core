package com.truongjae.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.truongjae.model.NewsModel;
import com.truongjae.service.INewsService;

@WebServlet(urlPatterns = "/admin-news")
public class NewsController extends HttpServlet{
	private static final long serialVersionUID = 4862599037321451246L;
	@Inject
	private INewsService iNewsService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewsModel newsModel = new NewsModel();
		newsModel.setListModel(iNewsService.findAll());
		req.setAttribute("listNewsModel", newsModel.getListModel());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/news/list.jsp");
		dispatcher.forward(req, resp);
	}
}
