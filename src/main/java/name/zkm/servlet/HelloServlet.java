package name.zkm.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 通过继承GenericServlet类来写Servlet，该类使用了适配器模式
 * 
 * @author Administrator
 *
 */
public class HelloServlet extends GenericServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public HelloServlet() {
		System.out.println("调用无参构造方法");
	}
	
	// 重写该方法做一些初始化干工作
	// 父类的该方法初始化了ServletConfig
	@Override
	public void init() {
		System.out.println("generic servlet init method called.");
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("genericServlet:service servlet" );
		
		// 调用父类的方法获取ServletConfig,ServletContext 
		ServletConfig config = getServletConfig();
		System.out.println(config.getServletName());
		
		ServletContext context = getServletContext();
		System.out.println(context.getContextPath());

	}

}
