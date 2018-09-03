package com.skcc.content.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcc.content.dao.ContentDao;
import com.skcc.content.vo.Content;

@Service("contentService")
public class ContentService {

	@Autowired
	private ContentDao contentDao;
	
	public List<Content> getContents(){
		return contentDao.getContents();
	}
	
	public Content getContentById(int id){
		return contentDao.getContentById(id);
	}
	
	public int createContent(Content content){
		return contentDao.createContent(content);
	}
	
	public void updateContent(int id, Content content){
		contentDao.updateContent(id, content);
	}
	
	public void deleteContent(int id){
		contentDao.deleteContent(id);
	}
	
	
}
