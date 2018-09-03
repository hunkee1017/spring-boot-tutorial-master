package com.skcc.content.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.content.service.ContentService;
import com.skcc.content.vo.Content;

@RestController
public class ContentController {
	
	private ContentService contentService;
	
	public ContentController(ContentService contentService){
		this.contentService = contentService;
	}
	
	@RequestMapping(path="/contents", method=RequestMethod.GET)
	public List<Content> getContents(){
		return contentService.getContents();
	}
	
	@RequestMapping(path="/contents/{id}", method=RequestMethod.GET)
	public Content getContent(@PathVariable("id")int id) {
		return contentService.getContentById(id);
	}
	
	@RequestMapping(path="/contents", method=RequestMethod.POST)
	public int createContent(@RequestBody Content content){
		return contentService.createContent(content);
	}
	
	@RequestMapping(path="/contents/{id}", method=RequestMethod.PUT)
	public int updateContent(@PathVariable(name="id") int id, @RequestBody Content content){
		content.setId(id);
		return contentService.updateContent(content);
	}
	
	@RequestMapping(path="/contents/{id}", method=RequestMethod.DELETE)
	public int deleteContents(@PathVariable("id")int id){
		return contentService.deleteContent(id);
	}
	
}
