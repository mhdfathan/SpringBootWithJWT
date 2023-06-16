package com.Mhdfathan.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Mhdfathan.Services.JobService;

@RestController
@RequestMapping(value = "/api/job")
public class JobController {

	@Autowired
	private JobService js;
	
	@GetMapping("/list")
	public Map<String,Object> getJobList(@RequestHeader("username") String username,@RequestHeader("token") String token) {
		Map<String,Object> ljob = new HashMap<>();
		ljob.put("Status", "OK");
		ljob.put("payload", js.getJobList(username, token));
		return ljob;
		
	}	
	
	@GetMapping("/findJob/{id}")
	public Map<String,Object> getJobById(@RequestHeader("username") String username,@RequestHeader("token") String token,@PathVariable String id) {
		Map<String,Object> ljob = new HashMap<>();
		RestTemplate rs = new RestTemplate();
		ljob.put("Status", "OK");
		ljob.put("payload", js.getJobListById(username, token, id));
		return ljob;
		
	}
}
