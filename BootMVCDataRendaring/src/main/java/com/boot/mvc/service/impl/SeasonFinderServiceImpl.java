package com.boot.mvc.service.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.boot.mvc.service.ISeasonFinderService;

@Service
public class SeasonFinderServiceImpl implements ISeasonFinderService{

	@Override
	public String findSeason() {
		//get system date
		LocalDate id=LocalDate.now();
		
		//get current month
		int month=id.getMonthValue();
		
		//find season
		if(month>=7 && month<=9)
			return"Rainy Season";
		else if(month>=3 && month<=6)
			return"Summer Season";
		else
		return "Winter Season";
	}

}
