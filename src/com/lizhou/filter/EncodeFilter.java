package com.lizhou.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 设置request的编码
 * @author bojiangzhou
 *
 */
public class EncodeFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse rep, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) rep;
		String a=request.getRequestURI();
        if(a.contains(".css") || a.contains(".js") || a.contains(".png")|| a.contains(".jpg")|| a.contains(".ico")|| a.contains(".gif")
        		|| a.contains(".eot")|| a.contains(".svg")|| a.contains(".ttf")|| a.contains(".woff")){
            //如果发现是css或者js文件，直接放行
        	request.setCharacterEncoding("UTF-8");
            chain.doFilter(request, response);
            }
         //在else中放对网页过滤的代码
        else{    
		//设置编码格式
		request.setCharacterEncoding("UTF-8");
		//设置返回类型
		response.setContentType("text/html; charset=utf-8");
		//放行资源
		chain.doFilter(request, response);
        }
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
