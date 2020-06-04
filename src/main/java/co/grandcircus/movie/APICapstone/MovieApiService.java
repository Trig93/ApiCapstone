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
	
	public List<Movie> getSearch (String search) {
		String url = "http://www.omdbapi.com/?s={search}&apikey={key}";
		MovieResponse response = rest.getForObject(url, MovieResponse.class, search, key);
		return response.getSearch();
		
	}


}
