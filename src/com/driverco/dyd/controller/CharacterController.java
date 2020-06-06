package com.driverco.dyd.controller;

import javax.servlet.http.HttpSession;

import com.driverco.dyd.model.CharacterVO;
import com.driverco.dyd.model.CommandVO;

public class CharacterController {
	public static void createCharacter(HttpSession appSession) {
		CharacterVO miCharacter = new CharacterVO();
		appSession.setAttribute("miCharacter",miCharacter);
		CommandsController.createCommandHistory(appSession);

		CommandsController.addCommandHistory(appSession, new CommandVO(true, "CreateCharacter", "Character "+miCharacter.getName()+" Created Succesfully"));
	}
	public static CharacterVO getCharacter(HttpSession appSession) {
		return (CharacterVO)appSession.getAttribute("miCharacter");
	}



}
