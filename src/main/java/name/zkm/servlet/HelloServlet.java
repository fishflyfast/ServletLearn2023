package name.zkm.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 最基本的Servlet。
 * 1.创建一个雷，实现Servlet接口，重写必要的方法
 * 2.在web.xml文件中进行配置。
 * 3.在Tomcat中部署该Servlet，在浏览器中访问。
 * 
 * @author Administrator
 *
 */
public class HelloServlet implements Servlet {

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
		System.out.println("service servlet");

	}

}
