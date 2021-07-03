package com.skilldistillery.film.controllers;

import org.springframework.*;
import org.springframework.web.bind.annotation.RequestMapping;

@controller

public class FilmController {

	
	
	@RequestMapping(path= {"/", "home.do"});
	public String index() {
		return "WEB-INF/home.jsp";
	}
	
}
