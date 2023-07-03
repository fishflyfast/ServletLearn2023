package name.zkm.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * Servlet的生命周期。
 * 1.Servlet默认是不会随着Tomcat启动的，而是在第一次访问时创建。如果需要自动启动，需要配置
 * 2.Servlet是单例多线程的。
 * 
 * @author Administrator
 *
 */
public class HelloServlet implements Servlet {

	// 此变量用来测试Servlet的单例多线程特性
	private int visited = 0;
	
	public HelloServlet() {
		System.out.println("调用无参构造方法");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy servlet");

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("init servlet");

	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		visited++;
		System.out.println("service servlet:visited:" + visited);

	}

}
