package com.driverco.dyd.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import com.driverco.dyd.controller.CharacterController;
import com.driverco.dyd.controller.HistoryController;
import com.driverco.dyd.view.CharacterView;
import com.driverco.dyd.view.CommandsView;

public class Character extends HttpServlet {

	private static final long serialVersionUID = 1883851184115329085L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession appSession = req.getSession(false);
		PrintWriter out;
		out = res.getWriter();
		res.setContentType("application/json");
		out.println("{\"hp\":\""+CharacterController.getCharacter(appSession).getCurrentHp()+"/"+CharacterController.getCharacter(appSession).getHp()+"\", \"location\":\""+CharacterView.getLocationString(HistoryController.getHistory(appSession).getLocation())+"\", \"battleStat\":\""+CharacterView.getStatusString(HistoryController.getHistory(appSession).getStatus())+"\"}");
	}


}
