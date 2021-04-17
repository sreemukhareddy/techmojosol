package com.sol.mojo.service;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.sol.mojo.exception.CustomException;

@Service
@EnableScheduling
public class MojoService {
	
	private static int CURRENT_HIT_COUNT = 0;
	private static int MAX_HIT_COUNT_PER_HOUR = 100;
	
	public int hitServer() {
		if(CURRENT_HIT_COUNT < MAX_HIT_COUNT_PER_HOUR) {
			CURRENT_HIT_COUNT++;
		} else {
			throw new CustomException("You've hit the server max times, please wait for 1 hour for the server to respond");
		}
		return CURRENT_HIT_COUNT;
	}
	
	@Scheduled(fixedRate = 1000 * 60 * 60) // 1000 ms * 60 s * 60 mnts, the scheduler will run for each hour and will restore the current hits to zero
	public void cleanUpStorage() {
		CURRENT_HIT_COUNT = 0;
	}

}
