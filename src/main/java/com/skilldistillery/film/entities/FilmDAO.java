package com.skilldistillery.film.entities;

import java.sql.SQLException;

import org.springframework.web.servlet.ModelAndView;

public interface FilmDAO {
	public Film getFilmById(int filmId);

}
