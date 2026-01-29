package com.boot.mvc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.mvc.service.ISeasonFinderService;

@Controller
public class SeasonOperationsController {

	@Autowired
	ISeasonFinderService service;

	
								//here the first one only taken by the dispatcherservlet
								// second one will be ignore
	//@GetMapping			
	//@PostMapping				//if we are not giving any API name here it automatically consider as "/"
//	@RequestMapping("/")      //in the new version of springboot new methods will provided for easy writing
	@PostMapping("/")
	public String showHome() {			//in MVC we use only two methods (GetMapping & PostMapping) because browser can only take these two
											//PostMapping=> for sending data
		return "welcome";					//GetMapping=> for retrieving data
	}										//PutMapping=> for updating data(Uses in REST)
											//DeleteMapping=> for delete data(Uses in REST)
											//PatchMapping=> for partial update data(Uses in REST)
	
	
	/*
	 * @RequestMapping("/") public String showHomes() { return "welcome"; }  // if we are taking same request path two time it cause exception
	 */
	
	//@RequestMapping("/season")
	@GetMapping("/season")			//here the first one only taken by the dispatcherservlet 
	//@PostMapping("/season")		// second one will be ignore 
	public String showSeason(Map<String, Object> map) {
		
		// use service
		String msg = service.findSeason();
		
		// keep result in model attributes
		map.put("resultMsg", msg);
		
		// return LVN
		return "display";
	}

}
