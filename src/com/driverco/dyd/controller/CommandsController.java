package com.driverco.dyd.controller;

import java.util.Vector;

import javax.servlet.http.HttpSession;

import com.driverco.dyd.model.CommandVO;

public class CommandsController {
    private static String[] commands={"hello", "hi", "run", "escape", "move", "attack", "where"};

	
	public static Vector<CommandVO> getCommandsHistory(HttpSession appSession) {
		return (Vector<CommandVO>) appSession.getAttribute("commandsHistory");
	}

	public static void createCommandHistory(HttpSession appSession) {
		Vector<CommandVO> commHist = new Vector<CommandVO>();
		commHist.add(new CommandVO(true, "GameStart", "Game Started"));
		appSession.setAttribute("commandsHistory", commHist);
	}

	public static void addCommandHistory(HttpSession appSession, CommandVO commVO) {
		Vector<CommandVO> commandsHist = (Vector<CommandVO>) appSession.getAttribute("commandsHistory");
		commandsHist.add(commVO);
		appSession.setAttribute("commandsHistory", commandsHist);
	}
	public static void receiveCommand(HttpSession appSession, CommandVO commVO) {
		if (validCommandWords(commVO)) {
			commVO = HistoryController.commandHistory(appSession, commVO);
		}else{
			commVO.setResults(false, "command not recongnized");
		}
		addCommandHistory(appSession, commVO);
	}
	private static boolean validCommandWords(CommandVO commVO) {
		for (String element : commands) {
		    if (commVO.getCommandString().toLowerCase().startsWith(element)) {
		        return true;
		    }
		}
		return false;
	}
}
