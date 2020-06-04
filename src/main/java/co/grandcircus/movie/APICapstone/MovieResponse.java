package co.grandcircus.movie.APICapstone;

import java.util.Arrays;

public class MovieResponse {
	
	private Movie[] Search;

	public Movie[] getSearch() {
		return Search;
	}

	public void setSearch(Movie[] search) {
		Search = search;
	}

	@Override
	public String toString() {
		return "MovieResponse [Search=" + Arrays.toString(Search) + "]";
	}
	

}
