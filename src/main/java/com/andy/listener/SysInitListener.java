package com.andy.Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SysInitListener  implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {}

	public void contextInitialized(ServletContextEvent event) {
		ServletContext  context =event.getServletContext();
		//全局上下文路径
		context.setAttribute("appPath", context.getContextPath());
	}

}