package com.capg.mms.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="tableMovie")
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long movieId;

	private String movieName;

	private String movieDirector;

	private String movieDescription;
	
	private String movieImg ;
	
	@OneToMany(mappedBy = "theMovie")
	@OnDelete(action=OnDeleteAction.CASCADE) 
	public List<Show> show;
	
	public Movie() {
		super();
	}
	public Movie(String movieName, String movieDirector, String movieDescription, String movieImg) {
		super();
		this.movieName = movieName;
		this.movieDirector = movieDirector;
		this.movieDescription = movieDescription;
		this.movieImg = movieImg;
	}
	public Movie(long movieId, String movieName, String movieDirector, String movieDescription, String movieImg,
			List<Show> show) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDirector = movieDirector;
		this.movieDescription = movieDescription;
		this.movieImg = movieImg;
		this.show = show;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieDirector=" + movieDirector
				+ ", movieDescription=" + movieDescription + ", movieImg=" + movieImg + ", show=" + show + "]";
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public String getMovieImg() {
		return movieImg;
	}

	public void setMovieImg(String movieImg) {
		this.movieImg = movieImg;
	}

	public List<Show> getShow() {
		return show;
	}

	public void setShow(List<Show> show) {
		this.show = show;
	}

	
}
