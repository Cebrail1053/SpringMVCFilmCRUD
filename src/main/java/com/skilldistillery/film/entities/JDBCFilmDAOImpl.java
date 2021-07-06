package com.skilldistillery.film.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCFilmDAOImpl implements FilmDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
//	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private String user = "student";
	private String pass = "student";
	private String sql;

	public JDBCFilmDAOImpl() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	}

	@Override
	public Film getFilmById(int filmId) {
		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			sql = "SELECT * FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				film = new Film(rs.getInt("id"), rs.getString("title"), rs.getInt("release_year"),
						rs.getString("description"), rs.getInt("language_id"), rs.getInt("rental_duration"),
						rs.getDouble("rental_rate"), rs.getDouble("replacement_cost"), rs.getInt("length"),
						rs.getString("rating"), rs.getString("special_features"));
				
				findFilmLanguageByCode(film);
				
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return film;
	}

	public Film createFilm(Film film) {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);
			sql = "INSERT INTO film (title, description, release_year, length, rating, special_features, language_id, rental_duration, rental_rate, replacement_cost) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, film.gettitle());
			stmt.setString(2, film.getdescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLength());
			stmt.setString(5, film.getrating());
			stmt.setString(6, film.getSpecialFeatures());
			stmt.setInt(7, 1);
			stmt.setDouble(8, film.getRentalDuration());
			stmt.setDouble(9, film.getRentalRate());
			stmt.setDouble(10, film.getReplacementCost());

			int uc = stmt.executeUpdate();
			System.out.println(uc + " film records created");

			ResultSet keys = stmt.getGeneratedKeys();
			int filmId = 0;
			if (keys.next()) {
				filmId = keys.getInt(1);
				System.out.println("New film ID: " + filmId);
			}
			if (filmId != 0) {
				film.setId(filmId);
				findFilmLanguageByCode(film);
			}

			conn.commit();
		} catch (SQLException sqle) {
			film = null;
			System.err.println("Error during inserts");
			sqle.printStackTrace();

			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error rolling back");
					sqle2.printStackTrace();
				}
			}
		}

		return film;
	}

	public Film deleteFilm(int filmId) {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);
			sql = "DELETE FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);

			int uc = stmt.executeUpdate();
			System.out.println(uc + " film records deleted");

			conn.commit();

		} catch (SQLException sqle) {
			System.err.println("Error during deletion");
			sqle.printStackTrace();

			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error rolling back");
					sqle2.printStackTrace();
				}
			}
		}

		return null;
	}

	public Film updateFilm(Film film) {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);
			sql = "UPDATE film SET title = ?, description = ?, release_year = ?, language_id = ?, "
					+ "rental_duration = ?, rental_rate = ?, replacement_cost = ?, length = ?, "
					+ "rating = ?, special_features = ? WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, film.gettitle());
			stmt.setString(2, film.getdescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLanguageId());
			stmt.setDouble(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setDouble(7, film.getReplacementCost());
			stmt.setInt(8, film.getLength());
			stmt.setString(9, film.getrating());
			stmt.setString(10, film.getSpecialFeatures());
			stmt.setInt(11, film.getId());
			
			findFilmLanguageByCode(film);

			int uc = stmt.executeUpdate();
			System.out.println(uc + " film records updated");

//			ResultSet keys = stmt.getGeneratedKeys();
//			if (keys.next()) {
//				f = getFilmById(keys.getInt(1));
//			}

			conn.commit();

		} catch (SQLException sqle) {
			System.err.println("Error during update");
			sqle.printStackTrace();

			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error rolling back");
					sqle2.printStackTrace();
				}
			}
		}

		return film;
	}

	public List<Film> findFilmsByKeyword(String keyword) {
		Connection conn = null;
		
		try {
			ArrayList<Film> list = new ArrayList<>();
			conn = DriverManager.getConnection(URL, user, pass);
			sql = "SELECT * FROM film WHERE title LIKE ? OR description LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Film film = new Film(rs.getInt("id"), rs.getString("title"), rs.getInt("release_year"),
						rs.getString("description"), rs.getInt("language_id"), rs.getInt("rental_duration"),
						rs.getDouble("rental_rate"), rs.getDouble("replacement_cost"), rs.getInt("length"),
						rs.getString("rating"), rs.getString("special_features"));

				list.add(film);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
			return list;
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return null;
	}
	
	public Film findFilmLanguageByCode(Film f) {
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			sql = "SELECT * FROM language WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, f.getLanguageId());
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				f.setLanguage(rs.getString("name"));
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return f;
	}
	
	public List<Actor> findActorsByFilmId(int filmId) {
		ArrayList<Actor> list = new ArrayList<>();
		
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			sql = "SELECT * FROM actor JOIN film_actor ON actor.id = film_actor.actor_id"
					+ " JOIN film ON film_actor.film_id = film.id" + " WHERE film.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Actor actor = new Actor(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
				
				list.add(actor);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return list;
	}
	
	public Film findCategoryByFilmId(Film f) {
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			sql = "SELECT * FROM category JOIN film_category ON category.id = film_category.category_id"
					+ " JOIN film ON film_category.film_id = film.id" + " WHERE film.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, f.getId());
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				f.setCategory(rs.getString("name"));
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return f;
	}
}
