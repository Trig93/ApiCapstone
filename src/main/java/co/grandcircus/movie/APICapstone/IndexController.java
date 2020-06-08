package co.grandcircus.movie.APICapstone;



import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;





@Controller
public class IndexController {
	
	@Autowired
	private MovieApiService service;
	@Autowired
	private MovieDao repository;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private HttpSession session;
	
	@RequestMapping ("/")
	public String home(Model model) {
		if (session.getAttribute("user") != null) {
			return "index";
		} else {
			return "login";
		}
	}
	
	@RequestMapping("/login/submit")
	public String submitLoginForm(@RequestParam("email") String email, @RequestParam("password") String password,
			Model model) {

		Optional<User> foundUser = userRepo.findByEmailAndPassword(email, password);
		if (foundUser.isPresent()) {
			session.setAttribute("user", foundUser.get());
			return "redirect:/";
		} else {
			model.addAttribute("message", "Incorrect email or password.");
			return "login";
		}
	}
	
	@RequestMapping ("/listofmovies")
	public String getByTitle(@RequestParam(name = "s") String title, @RequestParam(required = false, name = "year") String year, 
			@RequestParam(required = false, name = "type") String type, Model model) {
		List<Movie> movies = service.getSearch(title, year, type);
		model.addAttribute("movies", movies);
		return "listofmovies";
	}
	
	@RequestMapping ("/watchlist")
	public String getWatchlist(Model model) {		
		if (session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			model.addAttribute("movieList", repository.findByUserId(user.getId()));
			return "watchlist";
		} else {
			model.addAttribute("message", "Not logged in");
			return "login";
		}
		
	}
	
	@RequestMapping ("/movie-add")
	public String addMovie(Movie movie) {
		User user = (User) session.getAttribute("user");
		user = userRepo.findById(user.getId()).get();
		movie.setUser(user);
		repository.save(movie);
		return ("redirect:/");
	}
	
	@RequestMapping ("/watchlist/remove/{id}")
	public String removeMovie(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return "redirect:/watchlist";
	}
	
	@RequestMapping ("/moreinfo")
	public String getMoreInfo(@RequestParam("title") String title, Model model) {
		Movie movie = service.getMoreInfo(title);
		model.addAttribute("movie", movie);
		System.out.println(movie);
		return "moreinfo";
	}
	@RequestMapping("/signup")
	public String signUpForm() {
		
		return "signup-form";
	}
	
	
	@RequestMapping("/signup/submit")
	public String signUpSubmit(User user) {
				
		userRepo.save(user);
		
		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String logout(RedirectAttributes redir, Model model) {
		if (session.getAttribute("user") != null) {
			redir.addFlashAttribute("message","Logged out successfully");
			
			session.invalidate();
			return "redirect:/";
		} else {
			model.addAttribute("message", "Not logged in");
			return "login";
		}
	}
	
}
