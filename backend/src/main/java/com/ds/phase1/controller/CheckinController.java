package com.ds.phase1.controller;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ds.phase1.dto.UserCheckinResponse;
import com.ds.phase1.model.UserCheckin;
import com.ds.phase1.repository.UserCheckinRepository;

@RestController("/user")
public class CheckinController {

	
	@Autowired
	UserCheckinRepository repo;
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
	
	@CrossOrigin
	@PostMapping("/checkin")
	public UserCheckinResponse userCheckin(@RequestBody UserCheckin userCheckin) {
		Instant now = Instant.now();
		UserCheckinResponse response;
		
		UserCheckin checkin = repo.findByUserName(userCheckin.getUserName());
		
		if(null==checkin) {
			UserCheckin newUserCheckIn = new UserCheckin(userCheckin.getUserName(), now);
			repo.insert(newUserCheckIn);
			response = responseFromCheckin(newUserCheckIn,true);
		}else {
			checkin.setLastCheckInTime(now);
			repo.insert(checkin);
			response = responseFromCheckin(checkin,false);
		}
		
		return response;		
	}
	
	
	private UserCheckinResponse responseFromCheckin(UserCheckin userCheckin,boolean isNew) {
		UserCheckinResponse response = new UserCheckinResponse();
		response.setCheckinTime(userCheckin.getLastCheckInTime().toEpochMilli());
		response.setCheckinTimeString(formatter.format(Date.from(userCheckin.getLastCheckInTime())));
		response.setName(userCheckin.getUserName());
		response.setNew(isNew);
		return response;
	}
	
	@GetMapping("/health")
	public String serviceHealth() {
		return "up";
	}
}
