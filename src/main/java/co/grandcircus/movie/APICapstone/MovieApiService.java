package co.grandcircus.movie.APICapstone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieApiService {
	
	@Value ("${api.key}")
	private String key;
			
	private RestTemplate rest = new RestTemplate();
	
	public Movie getMovieByTitle(String title) {
		String url = "http://www.omdbapi.com/?t={title}&apikey={key}";
		Movie response = rest.getForObject(url, Movie.class, title, key);
		return response;
	}

}
