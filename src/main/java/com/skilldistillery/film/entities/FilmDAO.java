package com.skilldistillery.film.entities;

import java.util.List;

public interface FilmDAO {
	public Film getFilmById(int filmId);
	
	public boolean createFilm(Film film);
	
	public boolean deleteFilm(int filmId);
	
	public boolean updateFilm(Film film);
	
	public List<Film> findFilmsByKeyword(String keyword);
	
	public Film findFilmLanguageByCode(Film f);
	
	public List<Actor> findActorsByFilmId(int filmId);
	
	public Film findCategoryByFilmId(Film f);

}
