package com.ds.phase1.model;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Table("user_checkin")
public class UserCheckin implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PrimaryKey("user_name")
	private String userName;
	
	@Column("checkin")
	private Instant lastCheckInTime;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Instant getLastCheckInTime() {
		return lastCheckInTime;
	}
	public void setLastCheckInTime(Instant lastCheckInTime) {
		this.lastCheckInTime = lastCheckInTime;
	}
	public UserCheckin(String userName, Instant lastCheckInTime) {
		super();
		this.userName = userName;
		this.lastCheckInTime = lastCheckInTime;
	}
	@Override
	public String toString() {
		return "UserCheckin [userName=" + userName + ", lastCheckInTime=" + lastCheckInTime + "]";
	}
	
	
	
	
}
