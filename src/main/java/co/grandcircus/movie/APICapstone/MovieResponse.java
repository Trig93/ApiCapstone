package co.grandcircus.movie.APICapstone;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieResponse {
	
	@JsonProperty(value = "Search")
	private List<Movie> search;

	public List<Movie> getSearch() {
		return search;
	}

	public void setSearch(List<Movie> search) {
		this.search = search;
	}

	@Override
	public String toString() {
		return "MovieResponse [Search=" + search + "]";
	}

	
	

}
