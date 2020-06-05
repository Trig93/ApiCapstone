package co.grandcircus.movie.APICapstone;




import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieApiService {
	
	@Value ("${api.key}")
	private String key;
			
	private RestTemplate rest = new RestTemplate();
		
	public List<Movie> getSearch (String search, String year, String type) {
		if ((year == null || year.isEmpty()) && (type == null || type.isEmpty())) {
			String url = "http://www.omdbapi.com/?s={search}&apikey={key}";
			MovieResponse response = rest.getForObject(url, MovieResponse.class, search, key);
			return response.getSearch();
		} else if (year != null && type != null) {
			String url = "http://www.omdbapi.com/?s={search}&y={year}&type={type}&apikey={key}";
			MovieResponse response = rest.getForObject(url, MovieResponse.class, search, year, type, key);
			return response.getSearch();
		} else if ((type != null) && (year == null || year.isEmpty())) {
			String url = "http://www.omdbapi.com/?s={search}&type={type}&apikey={key}";
			MovieResponse response = rest.getForObject(url, MovieResponse.class, search, type, key);
			return response.getSearch();
		} else {
			String url = "http://www.omdbapi.com/?s={search}&y={year}&apikey={key}";
			MovieResponse response = rest.getForObject(url, MovieResponse.class, search, year, key);
			return response.getSearch();
		}
		
	}

}
