package com.skcc.content.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skcc.content.service.ContentService;
import com.skcc.content.vo.Content;

@Controller
public class ContentController {
	
	@Autowired
	private MessageSource messageSource;
	
	private ContentService contentService;
	
	public ContentController(ContentService contentService){
		this.contentService = contentService;
	}
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String getContents(HttpSession session, Model model){
		model.addAttribute("welcome", messageSource.getMessage("welcome", null, LocaleContextHolder.getLocale()));
		model.addAttribute("contents", contentService.getContents());
		return "welcome";
	}
	
	@RequestMapping(path="/contents/{id}", method=RequestMethod.GET)
	public String getContent(@PathVariable("id")int id, Model model){
		model.addAttribute("content", contentService.getContentById(id));
		return "edit";
	}
	
	@RequestMapping(path="/contents", method=RequestMethod.POST)
	public String createContent(Content content){
		contentService.createContent(content);
		return "redirect:/";
	}
	
	@RequestMapping(path="/contents/{id}", method=RequestMethod.PUT)
	public String updateContents(@PathVariable(name="id") int id, Content content){
		contentService.updateContent(id, content);
		return "redirect:/";
	}
	
	@RequestMapping(path="/contents/{id}", method=RequestMethod.DELETE)
	public String deleteContents(@PathVariable("id")int id){
		contentService.deleteContent(id);
		return "redirect:/";
	}
	
	
}
