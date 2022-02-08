package com.truongjae.controller.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.truongjae.model.NewsModel;
import com.truongjae.model.UserModel;
import com.truongjae.service.INewsService;
import com.truongjae.service.IUserService;
import com.truongjae.utils.FormUtil;
import com.truongjae.utils.HttpUtil;
import com.truongjae.utils.SessionUtil;

@WebServlet(urlPatterns = {"/login","/logout"})
public class HomeController extends HttpServlet{
	
	private static final long serialVersionUID = 5026862659623855549L;
	@Inject
	private IUserService iUserService;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null && action.equals("login")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/home.jsp");
			dispatcher.forward(req, resp);
		}
		else if(action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(req, "USERMODEL");
			resp.sendRedirect(req.getContextPath()+"/login");
		}
		else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/home.jsp");
			dispatcher.forward(req, resp);
		}
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/home.jsp");
//		dispatcher.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null && action.equals("login")) {
//			UserModel userModel = FormUtil.toModel(UserModel.class, req);
//			UserModel userModel = new UserModel();
//			userModel.setUserName(req.getParameter("userName"));
//			userModel.setPassword(req.getParameter("password"));
			UserModel userModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
			
			userModel = iUserService.findByUserNameAndPasswordAndStatus(userModel.getUserName(), userModel.getPassword(), 1);
			if(userModel != null) {
				SessionUtil.getInstance().putValue(req, "USERMODEL", userModel);
				if(userModel.getRole().getCode().equals("USER")) {
					resp.sendRedirect("views/web/user.jsp");
				}
				else if(userModel.getRole().getCode().equals("ADMIN")) {
					resp.sendRedirect("views/admin/admin.jsp");
				}
			}
			else {
				req.setAttribute("alert", "failLogin");
				resp.sendRedirect(req.getContextPath()+"/login?action=login");
			}
		}
		else {
			
			resp.sendRedirect(req.getContextPath()+"/login?action=login");
		}
		
	}
}
