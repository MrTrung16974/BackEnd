package com.laptrinhjavaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.service.HomeService;

@Controller
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	   public ModelAndView homePage() {
	      ModelAndView mav = new ModelAndView("home");
	     mav.addObject("menu", homeService.loadMenu());
	      return mav;
	   }
	@RequestMapping(value = "/spring-mvc", method = RequestMethod.GET)
	   public ModelAndView springMvcPage() {
	      ModelAndView mav = new ModelAndView("springmvc");
	     mav.addObject("menu", homeService.loadMenu());
	      return mav;
	   }
}
