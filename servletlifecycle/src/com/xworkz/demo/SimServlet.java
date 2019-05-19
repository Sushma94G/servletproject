package com.xworkz.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SimServlet extends GenericServlet{
	double availableBal;
	 public SimServlet() {
		System.out.println(this.getClass().getSimpleName()+" object created..");
	}
	 public void init(ServletConfig config) throws ServletException{
		 super.init(config);
		 config=getServletConfig();
		 String balance=config.getInitParameter("bal");
		 System.out.println("balance->"+balance);
		 this.availableBal=Double.parseDouble(balance);
		 System.out.println("---------------");
	 }

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
	System.out.println("service() method created..");
	double callCost=1.5;
	availableBal -=callCost;
	System.out.println("After the call = "+availableBal);
	PrintWriter out=resp.getWriter();
	out.println("<html><body>"
	+"<h1>Call Completed<br>"
	+"<b>Available balance="+availableBal+"</b></h1>"
			+"</body></html>");
	out.flush();
	out.close();
	
	System.out.println("service() metthod ended..");

		System.out.println("------------");
	
		
	}
	public void destroy(){
		System.out.println("destroy() method");
	}

}
