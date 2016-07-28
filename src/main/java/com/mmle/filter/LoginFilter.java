package com.mmle.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginFilter implements Filter {
    //过滤器销毁函数
	public void destroy() {
		// TODO Auto-generated method stub

	}

	//过滤器执行函数
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		
		//强制转化为父类
		HttpServletRequest req=(HttpServletRequest) request;
		//获取容器会话对象
		 Object obj = req.getSession().getAttribute("user");
		// System.out.println("执行过滤器="+obj.toString());
		System.out.println("执行过滤");
		 //判断是否为空
		 if(obj==null)
		 {
			 req.getRequestDispatcher("../../login.html").forward(request, response);
		 }
		 else
		 {
			//继续向下传递请求
				chain.doFilter(request, response);
		 }
		
	}

	//过滤器初始化函数
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("初始化过滤器");
	}

}
