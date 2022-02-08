package com.truongjae.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.truongjae.model.NewsModel;
import com.truongjae.model.RoleModel;
import com.truongjae.model.UserModel;
import com.truongjae.utils.SessionUtil;

@WebFilter(urlPatterns = {"/*"})
public class AuthorizationFiler implements Filter{
	
	
	private ServletContext context;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httServletResponse = (HttpServletResponse) response;
		String url = httpServletRequest.getRequestURI();
		System.out.println(url);
		if(url.startsWith("/NewsJDBC/admin")) {
			UserModel userModel =(UserModel) SessionUtil.getInstance().getValue(httpServletRequest,"USERMODEL");
			if(userModel != null) {
				if(userModel.getRole().getCode().equals("ADMIN")) {
					chain.doFilter(request, response);
				}
				else if(userModel.getRole().getCode().equals("USER")) {
					httpServletRequest.setAttribute("result", "may khong phai admin");
				}
			}
			else {
				httServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login");
			}
		}else {
			chain.doFilter(request, response);
		}
	}

}
