package com.skilldistillery.film.entities;

import java.util.List;

public interface FilmDAO {
	public Film getFilmById(int filmId);
	
	public boolean createFilm(Film film);
	
	public boolean deleteFilm(Integer filmId);
	
	public boolean updateFilm(Film film);
	
	public List<Film> findFilmsByKeyword(String keyword);
	
	public Film findFilmLanguageByCode(Film f);
	
	public Film findActorsByFilmId(Film film);
	
	public Film findCategoryByFilmId(Film f);

}
