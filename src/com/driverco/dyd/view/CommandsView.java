package com.driverco.dyd.view;

import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.servlet.http.HttpSession;

import com.driverco.dyd.controller.CommandsController;
import com.driverco.dyd.model.CommandVO;

public class CommandsView {
	public static String getCommandsHist(HttpSession appSession) {
		StringBuilder html = new StringBuilder();
		Vector<CommandVO> commHist = CommandsController.getCommandsHistory(appSession);
		
		for (int i = commHist.size() -1; i>=0;i--) {
			html.append("  <div class='commandLog "+(commHist.get(i).isSuccess()?"OK":"FAIL")+"'>");
			html.append(  commHist.get(i).getLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
			html.append(":(");
			html.append(  commHist.get(i).getCommandString());
			html.append(")");
			html.append(  commHist.get(i).getResults());
			html.append("  </div>");
			
		}
		return html.toString();
		
	}
}
