package com.skilldistillery.film.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.skilldistillery.filmquery.entities.Film;

public class JDBCFilmDAOImpl implements FilmDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private String user = "student";
	private String pass = "student";
	private String sql;
	
	public JDBCFilmDAOImpl() throws ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	@Override
	public Film getFilmById(int filmId) {
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			sql = "SELECT * FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				Film film = new Film(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
						rs.getInt("release_year"), rs.getInt("language_id"), rs.getInt("rental_duration"),
						rs.getDouble("rental_rate"), rs.getInt("length"), rs.getDouble("replacement_cost"),
						rs.getString("rating"), rs.getString("special_features"));
				
				return film;
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
			return null;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

}
