package com.skilldistillery.film.entities;

import java.util.List;

public interface FilmDAO {
	public Film getFilmById(int filmId);
	
	public Film createFilm(Film film);
	
	public Film deleteFilm(int filmId);
	
	public Film updateFilm(Film film);
	
	public List<Film> findFilmsByKeyword(String keyword);
	
	public Film findFilmLanguageByCode(Film f);
	
	public List<Actor> findActorsByFilmId(int filmId);
	
	public Film findCategoryByFilmId(Film f);

}
