package com.driverco.dyd.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import com.driverco.dyd.controller.CharacterController;
import com.driverco.dyd.controller.HistoryController;
import com.driverco.dyd.view.CharacterView;
import com.driverco.dyd.view.CommandsView;

public class Game extends HttpServlet {

	private static final long serialVersionUID = 1883851184115329085L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession appSession = req.getSession(true);
		CharacterController.createCharacter(appSession);
		HistoryController.createHistory(appSession);

		PrintWriter out;
		out = res.getWriter();
		res.setContentType("text/html");
		out.println(HTMLCommon.getHeader());
		out.println(CharacterView.getCharacterBox(appSession));
		out.println(Game.getCommandBox());
		out.println(Game.getCommandHistBox(appSession));
		out.println(HTMLCommon.getFooter());
	}

	private static String getCommandBox() {
		StringBuilder html = new StringBuilder();
		html.append("<div id='commandBox'>");
		html.append("  your command please:");
		html.append("  <input type='text' id='inputCommand' />");
		html.append("  <button id='send' onclick='javascript:sendCommand()'>Send</button>");
		html.append("  <script src=\"js/dyd.js\" type=\"text/javascript\"></script>");
		html.append("</div>");
		/*Command History*/
		return html.toString();

	}
	private static String getCommandHistBox(HttpSession appSession) {
		StringBuilder html = new StringBuilder();
		html.append("<div id='commandHist'>");
		html.append("  <div id='commandHistHeader'>Command History</div>");
		html.append("  <div id='commandHistLog'>");
		html.append(CommandsView.getCommandsHist(appSession));
		html.append("  </div>");
		html.append("</div>");
		return html.toString();
		
	}

}
