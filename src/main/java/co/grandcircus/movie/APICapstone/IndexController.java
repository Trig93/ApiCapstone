package co.grandcircus.movie.APICapstone;

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
	
	@RequestMapping ("/t")
	public String getByTitle(@RequestParam("t") String title, @RequestParam(required = false, name = "year") String year, 
			@RequestParam(required = false, name = "type") String type, Model model) {
		Movie[] movies = service.getMovieByTitle(title, type, year);
		model.addAttribute("title", movies);
		
		return "t";
	}
	
	

}
