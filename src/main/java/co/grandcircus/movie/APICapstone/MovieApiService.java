package co.grandcircus.movie.APICapstone;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieApiService {
	
	@Value ("${api.key}")
	private String key;
			
	private RestTemplate rest = new RestTemplate();
	
	public Movie[] getMovieByTitle(String title, String year, String type) {
		if (year == null || year.isEmpty() && type == null || type.isEmpty()) {
			String url = "http://www.omdbapi.com/?s={title}&apikey={key}";
			Movie[] response = rest.getForObject(url, Movie[].class, title, key);
			return response;
		}
		else if (year != null || ! year.isEmpty() && type != null || ! type.isEmpty()) {
			String url = "http://www.omdbapi.com/?s={title}&year={year}&type={type}&apikey={key}";
			Movie[] response = rest.getForObject(url, Movie[].class, title, year, type, key);
			return response;
		}
		else if (year != null || ! year.isEmpty()) {
			String url = "http://www.omdbapi.com/?s={title}&year={year}&apikey={key}";
			Movie[] response = rest.getForObject(url, Movie[].class, title, year, key);
			return response;
		}
		else {
			String url = "http://www.omdbapi.com/?s={title}&type={type}&apikey={key}";
			Movie[] response = rest.getForObject(url, Movie[].class, title, type, key);
			return response;
		}
	}


}
