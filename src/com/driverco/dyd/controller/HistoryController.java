package com.driverco.dyd.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import com.driverco.dyd.model.CommandVO;
import com.driverco.dyd.model.HistoryVO;
import com.driverco.dyd.view.CharacterView;

public class HistoryController {
	public static void createHistory(HttpSession appSession) {
		HistoryVO histVO = new HistoryVO();
		appSession.setAttribute("history", histVO);
		CommandsController.addCommandHistory(appSession, new CommandVO(true, "HistoryStart", "Story Begins in Town"));
	}

	public static HistoryVO getHistory(HttpSession appSession) {
		return (HistoryVO) appSession.getAttribute("history");
	}

	public static CommandVO commandHistory(HttpSession appSession, CommandVO commVO) {
		HistoryVO histVO = getHistory(appSession);
		/* greetings */
		if (commVO.getCommandString().toLowerCase().startsWith("hello")
				|| commVO.getCommandString().toLowerCase().startsWith("hi")) {
			if (histVO.getStatus() == HistoryVO.STAT_DEAD) {
				commVO.setResults(false, "You're scaring me, This is my first time listening to a ghost, hi casper!! (in the phone....Hello ghostbusters, I need help!)");
			} else {
				if (histVO.getStatus() == HistoryVO.STAT_BATTLE) {
					commVO.setResults(false, "This is no time to be polite");
				} else {
					commVO.setResults(true, "Hello " + CharacterController.getCharacter(appSession).getName()
							+ ", How are you?, are you having fun?");
				}
			}
		}
		/* move */
		if (commVO.getCommandString().toLowerCase().startsWith("move")) {
			if (histVO.getStatus() == HistoryVO.STAT_DEAD) {
				commVO.setResults(false, "Magic can`t revive the deads, maybe restarting the game will help");
			} else {
				if (histVO.getStatus() == HistoryVO.STAT_BATTLE) {
					commVO.setResults(false, "you can't move in battle");
				} else {
					if (commVO.getCommandString().toLowerCase().equals("move")) {
						commVO.setResults(false, "emptyness is not a location");
					}else {
						if (commVO.getCommandString().toLowerCase().contains("town")) {
							histVO.setLocation(HistoryVO.LOC_TOWN);
							commVO.setResults(true, "You are in the Town");
							
							if (CharacterController.getCharacter(appSession).getCurrentHp()<CharacterController.getCharacter(appSession).getHp()) {
								CommandsController.addCommandHistory(appSession, commVO);
								CharacterController.getCharacter(appSession).heal();
								commVO = new CommandVO(true,"Heal","you were healed");
							}
						} else {
							if (commVO.getCommandString().toLowerCase().contains("river")) {
								histVO.setLocation(HistoryVO.LOC_RIVER);
								commVO.setResults(true, "You are in the River");
							} else if (commVO.getCommandString().toLowerCase().contains("mountain")) {
								histVO.setLocation(HistoryVO.LOC_MOUNTAIN);
								commVO.setResults(true, "You are in the Mountain");
							} else if (commVO.getCommandString().toLowerCase().contains("forest")) {
								histVO.setLocation(HistoryVO.LOC_FOREST);
								commVO.setResults(true, "You are in the Forest");
							} else if (commVO.getCommandString().toLowerCase().contains("plains")) {
								histVO.setLocation(HistoryVO.LOC_PLAINS);
								commVO.setResults(true, "You are in the Plains");
							} else {
								commVO.setResults(false, "location unknown");
							}
							Random r = new Random();
							int randomNumber = r.nextInt(100);
							if (randomNumber > 50) {
								histVO.setStatus(HistoryVO.STAT_BATTLE);
								CommandsController.addCommandHistory(appSession, commVO);
								CommandsController.addCommandHistory(appSession, new CommandVO(true,"Battle","You are in Battle"));
								commVO = new CommandVO(true,"Battle","Enemy="+histVO.getEnemy().getName()+":HP="+histVO.getEnemy().getHp()+":Atk="+histVO.getEnemy().getPower());
							}
						}
					}
				}
			}
		}
		if (commVO.getCommandString().toLowerCase().startsWith("attack")){
			if (histVO.getStatus() == HistoryVO.STAT_DEAD) {
				commVO.setResults(false, "you can`t fight as a ghost");
			}else {
				if(histVO.getStatus() == HistoryVO.STAT_OK) {
					commVO.setResults(false, "do you want a heart attack?");
				}else {
					histVO.getEnemy().attack(CharacterController.getCharacter(appSession).getPower());
					if (histVO.getEnemy().getHp()==0) {
						histVO.setStatus(HistoryVO.STAT_OK);
						commVO.setResults(true, "you've killed the foe, you're free to go");
					}else {
						CharacterController.getCharacter(appSession).attack(histVO.getEnemy().getPower());
						if (CharacterController.getCharacter(appSession).getCurrentHp()==0) {
							commVO.setResults(true, "you are dead, "+histVO.getEnemy().getName()+" is the winner");
							histVO.setStatus(HistoryVO.STAT_DEAD);
						}else {
							commVO.setResults(true,"Enemy="+histVO.getEnemy().getName()+":HP="+histVO.getEnemy().getHp()+":Atk="+histVO.getEnemy().getPower());
						}
					}
				}
			}
		}
		
		
		if (commVO.getCommandString().toLowerCase().startsWith("run")
				|| commVO.getCommandString().toLowerCase().startsWith("escape")) {
			if (histVO.getStatus() == HistoryVO.STAT_DEAD) {
				commVO.setResults(false, "are you kidding me?, escape from dead?, really?");
			} else {
				if (histVO.getStatus() == HistoryVO.STAT_BATTLE) {
					Random r = new Random();
					int randomNumber = r.nextInt(100);
					if (randomNumber > 33) {
						commVO.setResults(true, "Chicken!!!, you've escaped from battle");
						histVO.setStatus(HistoryVO.STAT_OK);
					} else {
						commVO.setResults(false, "it's no time to run!, you can't escape");
					}
				} else {
					commVO.setResults(false,
							"escape from..." + CharacterView.getLocationString(histVO.getLocation()) + "?, really?");
				}
			}
		}
		if (commVO.getCommandString().toLowerCase().startsWith("where")) {
			commVO.setResults(true, "you are in the " + CharacterView.getLocationString(histVO.getLocation()));
		}
		return commVO;
	}
}
