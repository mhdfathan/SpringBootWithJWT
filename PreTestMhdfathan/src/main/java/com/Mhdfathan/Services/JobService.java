package com.Mhdfathan.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Mhdfathan.Repositories.UserLoginRepository;
import com.Mhdfathan.model.Job;
import com.Mhdfathan.model.UserEntity;

@Service
public class JobService {
	@Autowired
	private UserLoginRepository ulr;

	public Map<String,Object> getJobList(String Username,String token){
		Map<String,Object> jmap = new HashMap<>();
		RestTemplate rs = new RestTemplate();
		if(cekUserToken(Username, token)){
			jmap.put("resCode", 1);
			jmap.put("msg", "Correct Token");
			jmap.put("data", rs.getForObject("http://dev3.dansmultipro.co.id/api/recruitment/positions.json", Map.class));
			return jmap;
		}else {
			jmap.put("resCode", -99);
			jmap.put("msg", "Your Token is Wrong or Expired");
			jmap.put("data", "Data Not Found");
			return jmap;
		}
	}
	
	public Map<String,Object> getJobListById(String Username,String token,String id){
		Map<String,Object> jmap = new HashMap<>();
		RestTemplate rs = new RestTemplate();
		if(cekUserToken(Username, token)){
			jmap.put("resCode", 1);
			jmap.put("msg", "Correct Token");
			jmap.put("data", rs.getForObject("http://dev3.dansmultipro.co.id/api/recruitment/positions/"+id, Map.class));
			return jmap;
		}else {
			jmap.put("resCode", -99);
			jmap.put("msg", "Your Token is Wrong or Expired");
			jmap.put("data", "Data Not Found");
			return jmap;
		}
	}
	
	public boolean cekUserToken(String Username,String Token) {
		UserEntity users = ulr.findByUsernameAndToken(Username, Token);
		if(users.getUsername()!="" && users.getToken()!="") {
			return true;
		}else {
			return false;
		}
	}
}
