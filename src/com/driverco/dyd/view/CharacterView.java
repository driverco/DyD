package com.driverco.dyd.view;

import javax.servlet.http.HttpSession;

import com.driverco.dyd.controller.CharacterController;
import com.driverco.dyd.controller.HistoryController;
import com.driverco.dyd.model.CharacterVO;
import com.driverco.dyd.model.HistoryVO;

public class CharacterView {
	public static String getCharacterBox(HttpSession appSession){
		CharacterVO userCharacter = CharacterController.getCharacter(appSession);
		StringBuilder html = new StringBuilder();
		html.append("    <div id='characterBox'>");
		html.append("      <table id='characterTable'>");
		html.append("        <tr class='characterHeader'>");
		html.append("          <td>Name</td>");
		html.append("          <td>Power</td>");
		html.append("          <td>Defense</td>");
		html.append("          <td>Hp</td>");
		html.append("          <td>Location</td>");
		html.append("          <td>Status</td>");
		html.append("        </tr>");
		html.append("        <tr class='characterData'>");
		html.append("          <td><i class='fas fa-khanda'></i><div id='characterName' >"+userCharacter.getName()+"</div></td>");
		html.append("          <td><i class='fas fa-bolt'></i><div id='characterPower' >"+userCharacter.getPower()+"</div></td>");
		html.append("          <td><i class='fas fa-shield-alt'></i><div id='characterDefense' >"+userCharacter.getDefense()+"</div></td>");
		html.append("          <td><i class='fas fa-heart'></i><div id='characterHp' >"+userCharacter.getCurrentHp()+"/"+userCharacter.getHp()+"</div></td>");
		html.append("          <td><div id='location' >"+getLocationString(HistoryController.getHistory(appSession).getLocation()  )+"</div></td>");
		html.append("          <td><div id='battleStat' >"+getStatusString(HistoryController.getHistory(appSession).getStatus()  )+"</div></td>");
		html.append("        </tr>");
		html.append("      </table>");
		html.append("    </div>");
		return html.toString();
	}
	public static String getLocationString(int location) {
		switch (location) {
		case HistoryVO.LOC_TOWN: return "Town";
		case HistoryVO.LOC_FOREST: return "Forest";
		case HistoryVO.LOC_MOUNTAIN: return "Mountain";
		case HistoryVO.LOC_PLAINS: return "Plains";
		case HistoryVO.LOC_RIVER: return "River";
		default: return "bad Location";
		}
	}
	public static String getStatusString(int status) {
		switch (status) {
		case HistoryVO.STAT_OK: return "OK";
		case HistoryVO.STAT_DEAD: return "Dead";
		case HistoryVO.STAT_BATTLE: return "Battle";
		default: return "bad Status";
		}
	}


}
