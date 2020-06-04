package co.grandcircus.movie.APICapstone;

import java.util.List;

public class MovieResponse {
	
	private List<Movie> Search;

	public List<Movie> getSearch() {
		return Search;
	}

	public void setSearch(List<Movie> search) {
		Search = search;
	}

	@Override
	public String toString() {
		return "MovieResponse [Search=" + Search + "]";
	}

	
	

}
