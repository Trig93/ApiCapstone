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
		model.addAttribute("movie", service.getMovieByTitle(""));
		return "index";
	}
	
	@RequestMapping ("/t")
	public String getByTitle(@RequestParam("t") String title, Model model) {
		Movie movie = service.getMovieByTitle(title);
		model.addAttribute("title", movie);
		return "t";
	}

}
