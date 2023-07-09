package name.zkm.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet2 implements Servlet {

	private ServletConfig config;
	@Override
	public void destroy() {

	}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		config = arg0;

	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		ServletContext app = config.getServletContext();
		Enumeration<String> names = app.getAttributeNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			System.out.println("name:" + name + ",value:" + app.getAttribute(name));
		}
		
	}

}
