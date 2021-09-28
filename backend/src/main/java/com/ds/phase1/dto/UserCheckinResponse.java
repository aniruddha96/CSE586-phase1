package com.ds.phase1.dto;

import java.io.Serializable;

public class UserCheckinResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean isNew;
	String name;
	String checkinTimeString;
	long checkinTime;
	
	public boolean isNew() {
		return isNew;
	}
	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCheckinTimeString() {
		return checkinTimeString;
	}
	public void setCheckinTimeString(String checkinTimeString) {
		this.checkinTimeString = checkinTimeString;
	}
	public long getCheckinTime() {
		return checkinTime;
	}
	public void setCheckinTime(long checkinTime) {
		this.checkinTime = checkinTime;
	}
	
	
	
}
