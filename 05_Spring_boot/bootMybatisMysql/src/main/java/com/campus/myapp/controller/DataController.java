package com.campus.myapp.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.campus.myapp.service.DataService;

@RestController
@RequestMapping("/data/*")
public class DataController {
	@Inject
	DataService service;
	
	ModelAndView mav = null;
    @GetMapping("dataList")
	public ModelAndView dataList() {
	
		mav= new ModelAndView();
		
		//DBÁ¶È¸
		mav.addObject("dataList", service.dataAllSelect());
		mav.setViewName("data/dataList");
		return mav;
	}
    @GetMapping("dataWrite")
    public ModelAndView dataWrite() {
    	mav = new ModelAndView();
    	mav.setViewName("data/dataWrite");
    	return mav;
    }
}
