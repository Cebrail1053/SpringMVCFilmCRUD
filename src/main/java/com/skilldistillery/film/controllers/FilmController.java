package com.skilldistillery.film.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.entities.Film;
import com.skilldistillery.film.entities.FilmDAO;

@Controller
public class FilmController {
	
	@Autowired
	private FilmDAO filmDAO;
	
	@RequestMapping(path= {"/", "home.do"})
	public String index() {
		return "WEB-INF/Index.jsp";
	}
	
	@RequestMapping(path="getFilm.do", method=RequestMethod.GET)
	public ModelAndView getFilmById(int filmId) {
		ModelAndView mv = new ModelAndView();
		Film f = filmDAO.getFilmById(filmId);
		mv.addObject("film", f);
		mv.setViewName("WEB-INF/SearchByID.jsp");
		return mv;
	}
	
	@RequestMapping(path="newFilm.do", method=RequestMethod.POST)
	public ModelAndView createFilm(Film film, RedirectAttributes redir) {
		System.out.println(film);
		ModelAndView mv = new ModelAndView();
		boolean f = filmDAO.createFilm(film);
		if (f) {
			redir.addFlashAttribute("createdFilm", f);
			mv.setViewName("redirect: createdFilm.do");
		} else {
			mv.setViewName("WEB-INF/TaskFail.jsp");
		}
		return mv;
	}
	
	@RequestMapping(path="createdFilm.do", method=RequestMethod.GET)
	public ModelAndView filmCreated() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/TaskSuccess.jsp");
		return mv;
	}
	
	@RequestMapping(path="deleteFilm.do", method=RequestMethod.POST)
	public ModelAndView deleteFilm(int filmId, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		boolean f = filmDAO.deleteFilm(filmId);
		if (f) {
			redir.addFlashAttribute("deleteFilm", f);
			mv.setViewName("redirect: filmDeleted.do");
		} else {
			mv.setViewName("WEB-INF/TaskFail.jsp");
		}
		return mv;
	}
	
	@RequestMapping(path="filmDeleted.do", method=RequestMethod.GET)
	public ModelAndView filmDeleted() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/TaskSuccess.jsp");
		return mv;
	}
	
	@RequestMapping(path="updateFilm.do", method=RequestMethod.POST)
	public ModelAndView updateFilm(Film film, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		boolean f = filmDAO.updateFilm(film);
		if(f) {
			redir.addFlashAttribute("updatedFilm", f);
			mv.setViewName("redirect: filmUpdated.do");
		} else {
			mv.setViewName("WEB-INF/TaskFail.jsp");
		}
		return mv;
	}
	
	@RequestMapping(path="filmUpdated.do", method=RequestMethod.GET)
	public ModelAndView filmUpdated() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/TaskSuccess.jsp");
		return mv;
	}
	
	@RequestMapping(path="keywordSearch.do", method=RequestMethod.GET)
	public ModelAndView getFilmsByKeyword(String keyword) {
		ModelAndView mv = new ModelAndView();
		List<Film> films = filmDAO.findFilmsByKeyword(keyword);
		mv.addObject("films", films);
		mv.setViewName("WEB-INF/SeachByKeyword.jsp");
		return mv;
	}
}
