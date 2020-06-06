package com.driverco.dyd.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class Index extends HttpServlet {

	private static final long serialVersionUID = -8377070293076732779L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out;
		out = res.getWriter();
		res.setContentType("text/html");

		out.println(HTMLCommon.getHeader());
		out.println(HTMLCommon.getStartPage());
		out.println(HTMLCommon.getFooter());
	}

}
