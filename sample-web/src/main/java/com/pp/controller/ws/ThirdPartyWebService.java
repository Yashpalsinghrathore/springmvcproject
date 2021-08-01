package com.pp.controller.ws;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.pp.model.Product;
@Controller
public class ThirdPartyWebService {


	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(method=RequestMethod.GET,value="/getEmployee/{id}")
	@ResponseBody
	public String getEmployee(@PathVariable String id) 
	{
		
		System.out.println("getEmployee");
		
		HttpHeaders headers = new HttpHeaders();
		

		headers.setContentType(MediaType.APPLICATION_JSON);
	
		
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		

		headers.set("email","yash@gmail.com");
		
		headers.set("password","12345");
		
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		String url = "http://localhost:9090/sample-web/getValueOfEmployee/1";
		
		restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		
		
		return "getEmployee";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/saveEmployee")
	@ResponseBody
	public String addEmployee(@RequestBody Product p) 
	{
	
		System.out.println(p.getProductName());
		System.out.println(p.getPrice());
		System.out.println(p.getDescription());
		System.out.println(p.getExpiryDate());
		
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("productName",p.getProductName());
		map.put("price",p.getPrice());
		map.put("description",p.getDescription());
		map.put("expiryDate",p.getExpiryDate());
		/*
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		
		map.add("productName",p.getProductName());
		map.add("price",p.getPrice());
		map.add("description",p.getDescription());
		map.add("expiryDate",p.getExpiryDate());*/
		
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		headers.set("email","yash@gmail.com");
		
		headers.set("password","12345");
		//HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map,headers);
		
		HttpEntity<Map<String, String>> request = new HttpEntity<Map<String, String>>(map,headers);
		
		String url = "http://localhost:9090/sample-web/saveValueOfEmployee";
		
		System.out.println("before rest templete call");
		
		restTemplate.postForEntity(url, request, String.class);
		 
		//Gson class used for converting string to json
		
		
		return "saveEmployee";
		
		
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
}
