package name.zkm.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * ServletContext:应用的全局配置,还有另一个名称：application。
 * 1.在Web.xml中写入全局参数，各个Servlet中都能用
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
		return config;
	}

	@Override
	public String getServletInfo() {
		return config.getServletName();
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("init servlet");
		this.config = arg0; // 接住ServletConfig
		
		System.out.println("servletName:" + config.getServletName());
		System.out.println("servletContextPath:" + config.getServletContext().getContextPath());
		
		// 获取应用的参数
		ServletContext application = config.getServletContext();
		Enumeration<String> en = application.getInitParameterNames();
		while(en.hasMoreElements()) {
			String paramName = en.nextElement();
			System.out.println("app param name:" + paramName + ",paramValue:" + application.getInitParameter(paramName));
		}
		
		System.out.println(application.getRealPath(getServletInfo()));
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("service servlet" );
		ServletContext app = config.getServletContext();
		app.setAttribute("att1", "this is setted by app");
		app.setAttribute("att2", "this is setted by app too");

	}

}
