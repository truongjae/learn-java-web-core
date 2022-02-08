package com.truongjae;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/formnguoidung")
public class FormPerson extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<form action='themnguoidung' method='post'>");
		printWriter.println("ten: <input type='text' name='ten'>");
		printWriter.println("tuoi: <input type='text' name='tuoi'>");
		printWriter.println("<input type='submit' value='submit'>");
		printWriter.println("</form>");
	}
}
