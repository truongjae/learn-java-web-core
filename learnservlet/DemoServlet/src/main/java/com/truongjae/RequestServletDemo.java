package com.truongjae;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/requestdemo")
public class RequestServletDemo extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getMethod());
		System.out.println(req.getContentType());
		System.err.println(req.getContextPath());
		System.out.println(req.getCookies());
		System.out.println(req.getSession());
		
		Enumeration<String> keys = req.getHeaderNames();
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			System.out.println(key+":"+req.getHeader(key));
		}
	}

}
