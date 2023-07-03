package name.zkm.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * ServletConfig:Servlet的配置。
 * 1.Servlet的配置封装在ServletConfig中，这是个接口。封装后的对象会在init方法中传进来
 * 2.一般会在类中写一个私有变量，用来承接ServletConfig，以便后续使用。
 * 
 * @author Administrator
 *
 */
public class HelloServlet implements Servlet {
	
	private ServletConfig config;
	
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
		this.config = arg0; // 接住ServletConfig
		
		System.out.println("servletName:" + config.getServletName());
		System.out.println("servletContextPath:" + config.getServletContext().getContextPath());
		Enumeration<String> en = config.getInitParameterNames();
		while(en.hasMoreElements()) {
			String paramName = en.nextElement();
			System.out.println("paramName:" + paramName + ",paramValue:" + config.getInitParameter(paramName));
		}
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("service servlet" );
		String paramValue = config.getInitParameter("param1");
		System.out.println("paramName:param1, paramValue:" + paramValue);

	}

}
