package com.skeye.water_fountain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mainController")
public class MainController {
	@RequestMapping("/toFront")
	public String ToFront()
	{
		return "/views/main/front";
	}
	
	@RequestMapping("/toAfter")
	public String ToAfter()
	{
		return "/views/main/after";
	}
}
