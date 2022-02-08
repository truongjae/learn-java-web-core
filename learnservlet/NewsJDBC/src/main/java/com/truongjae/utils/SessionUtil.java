package com.truongjae.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
	private static SessionUtil sessionUtil = null;
	public static SessionUtil getInstance() {
		if(sessionUtil == null) {
		sessionUtil= new SessionUtil();
		}
		return sessionUtil;
	}
	public void putValue(HttpServletRequest req, String key, Object value) {
		req.getSession().setAttribute(key, value);
	}
	public Object getValue(HttpServletRequest req, String key) {
		Object value = req.getSession().getAttribute(key);
		return value;
	}
	public void removeValue(HttpServletRequest req,String key) {
		req.getSession().removeAttribute(key);
	}
}
