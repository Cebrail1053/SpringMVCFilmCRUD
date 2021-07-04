package com.skilldistillery.film.entities;

import java.util.List;

public class Film {

	private int id;
	private String title;
	private int releaseYear;
	private String description;
	private int languageId;
	private double rentalDuration;
	private double rentalRate;
	private double replacementCost;
	private int length;
	private String rating;
	private String specialFeatures;
	private List<Actor> actors;
	private String language;
	private String category;


	public Film() {
		super();
	}

	public Film(int id, String title, int releaseYear, String description, int languageId, 
			double rentalDuration, double rentalRate, double replacementCost, int length, String rating,
			 String specialFeatures) {
		super();
		this.id = id;
		this.title = title;
		this.releaseYear = releaseYear;
		this.description = description;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.replacementCost = replacementCost;
		this.length = length;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title = title;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public double getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(double rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getrating() {
		return rating;
	}

	public void setrating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public String filmInfo() {
		return "Film [title=" + title + ", releaseYear=" + releaseYear + ", description="
				+ description + ", language=" + ", rating=" + rating + "]";
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", releaseYear=" + releaseYear + ", description="
				+ description + ", languageId=" + languageId + ", language=" +  ", rentalDuration="
				+ rentalDuration + ", rentalRate=" + rentalRate + ", replacementCost=" + replacementCost + ", length="
				+ length + ", rating=" + rating + ", specialFeatures="
				+ specialFeatures + ", categories=" + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + languageId;
		result = prime * result + length;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + releaseYear;
		long temp;
		temp = Double.doubleToLongBits(rentalDuration);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rentalRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(replacementCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (languageId != other.languageId)
			return false;
		if (length != other.length)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear != other.releaseYear)
			return false;
		if (Double.doubleToLongBits(rentalDuration) != Double.doubleToLongBits(other.rentalDuration))
			return false;
		if (Double.doubleToLongBits(rentalRate) != Double.doubleToLongBits(other.rentalRate))
			return false;
		if (Double.doubleToLongBits(replacementCost) != Double.doubleToLongBits(other.replacementCost))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
