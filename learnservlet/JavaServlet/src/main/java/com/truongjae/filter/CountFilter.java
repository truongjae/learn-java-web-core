package com.truongjae.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns = "/*")
public class CountFilter implements Filter{
	private int count = 0;
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		this.count++;
		System.out.println(count);
		chain.doFilter(request, response);
		
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.count = 0;
	}

}
