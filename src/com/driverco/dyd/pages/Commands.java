package com.driverco.dyd.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.driverco.dyd.controller.CommandsController;
import com.driverco.dyd.model.CommandVO;
import com.driverco.dyd.view.CommandsView;

public class Commands extends HttpServlet {


	private static final long serialVersionUID = 5869010226884237202L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession appSession = req.getSession(false);
		res.setContentType("text/html");
		PrintWriter out;
		out = res.getWriter();
		String command = req.getParameter("Command");
		CommandsController.receiveCommand(appSession, new CommandVO(command)); 
		out.println(CommandsView.getCommandsHist(appSession));
	}

}
