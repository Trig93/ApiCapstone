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
	
	@RequestMapping ("/")
	public String home(Model model) {
		return "index";
	}
	
	@RequestMapping ("/s")
	public String getByTitle(@RequestParam("s") String title, @RequestParam(required = false, name = "year") String year, 
			@RequestParam(required = false, name = "type") String type, Model model) {
		List<Movie> movies = service.getSearch(title, year, type);
		System.out.println(movies);
		model.addAttribute("movies", movies);
		return "s";
	}
}
