package com.skcc.content.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.skcc.content.vo.Content;

@Repository("contentsDao")
public class ContentDao {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${rest.address}")
	private String restAddress;
	
	private static final String CONTENT_ADDRESS = "/contents";
	
	public List<Content> getContents(){
		Content[] contents = restTemplate.getForObject(restAddress + CONTENT_ADDRESS, Content[].class);
		return Arrays.asList(contents);
	}
	
	public Content getContentById(int id){
		return restTemplate.getForObject(restAddress + CONTENT_ADDRESS + "/{id}", Content.class, id);
	}
	
	public int createContent(Content content){
		return restTemplate.postForObject(restAddress + CONTENT_ADDRESS, content, Integer.class);
	}
	
	public void updateContent(int id, Content content){
		restTemplate.put(restAddress + CONTENT_ADDRESS + "/{id}", content, id);
	}
	
	public void deleteContent(int id){
		restTemplate.delete(restAddress + CONTENT_ADDRESS + "/{id}", id);
	}

}
