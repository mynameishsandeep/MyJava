package com.sample.codeinterview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import lombok.Getter;
import lombok.Setter;

/**
 * Find the related movies with rating greater the passed movies - asked in Amazon
 */
@Getter
@Setter
public class Movie {
	private int id;
	private int rating;
	private List<Movie> relatedMovie;

	public static void main(String[] args) {
		Movie m1 = new Movie();
		m1.setId(1);
		m1.setRating(1);

		Movie m2 = new Movie();
		m2.setId(2);
		m2.setRating(2);

		Movie m3 = new Movie();
		m3.setId(3);
		m3.setRating(3);

		Movie m4 = new Movie();
		m4.setId(4);
		m4.setRating(0);

		List<Movie> r = new ArrayList<>();
		r.add(m2);
		r.add(m3);
		r.add(m4);

		m1.setRelatedMovie(r);

		List<Movie> result = new Movie().findRelatedMovie(m1);
		for (Movie move : result) {
			System.out.println(move.getId());
		}
	}

	public List<Movie> findRelatedMovie(Movie movie) {
		Stack<Movie> movieList = new Stack<>();
		movieList.push(movie);
		int rating = movie.getRating();
		List<Movie> result = new ArrayList<>();
		while (!movieList.empty()) {
			Movie m = movieList.pop();
			List<Movie> l = m.getRelatedMovie();
			if (l != null) {
				for (Movie move : l) {
					if (move.getRating() > rating) {
						result.add(move);
						movieList.push(move);
					}
				}
			}
		}
		return result;
	}
}
