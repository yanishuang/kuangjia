package cn.yanis.coffice.framework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/*",loadOnStartup=0)
public class DispatcherServlet  extends HttpServlet{

	@Override
	public void init() throws ServletException {
	   //初始化相关的Helper
		HelperLoader.init();
		//获取servletContext
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}
	
}
