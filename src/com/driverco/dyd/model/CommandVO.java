package com.driverco.dyd.model;

import java.time.LocalDateTime;

public class CommandVO {
	private boolean success;
	private LocalDateTime date;
	private String commandString;
	private String results;
	
	public CommandVO(String commandStringin) {
		super();
		this.commandString = commandStringin;
		this.date = LocalDateTime.now();
	}
	public CommandVO(boolean success, String commandStringin, String results) {
		super();
		this.commandString = commandStringin;
		this.date = LocalDateTime.now();
		this.success = success;
		this.commandString = commandStringin;
		this.results = results;
	}
	public boolean isSuccess() {
		return success;
	}
	public String getResults() {
		return results;
	}
	public void setResults(boolean success, String results) {
		this.success = success;
		this.results = results;
	}
	public LocalDateTime getLocalDateTime() {
		return date;
	}
	public String getCommandString() {
		return commandString;
	}
}
