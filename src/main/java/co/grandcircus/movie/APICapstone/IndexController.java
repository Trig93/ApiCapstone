package co.grandcircus.movie.APICapstone;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
	
	@Autowired
	private MovieApiService service;
	@Autowired
	private MovieDao repository;
	
	@RequestMapping ("/")
	public String home(Model model) {
		return "index";
	}
	
	@RequestMapping ("/listofmovies")
	public String getByTitle(@RequestParam("s") String title, @RequestParam(required = false, name = "year") String year, 
			@RequestParam(required = false, name = "type") String type, Model model) {
		List<Movie> movies = service.getSearch(title, year, type);
		model.addAttribute("movies", movies);
		return "listofmovies";
	}
	
	@RequestMapping ("/watchlist")
	public String getWatchlist(Model model) {
		List <Movie> movieList = repository.findAll();
		model.addAttribute("movieList", movieList);
		return "watchlist";
		
	}
	
	@RequestMapping ("/movie-add")
	public String addMovie(@RequestParam("movie") Movie movie) {
		repository.save(movie);
		return ("redirect:/listofmovies");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
