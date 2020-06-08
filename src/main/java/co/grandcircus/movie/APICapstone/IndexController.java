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



// Controller for all views

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
	
	@RequestMapping ("/") // Home page
	public String home(Model model) {
		if (session.getAttribute("user") != null) {
			return "index";
		} else {
			return "login";
		}
	}
	
	@RequestMapping("/login/submit") // Login page
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
	
	@RequestMapping ("/listofmovies") // List that generates movies based on search criteria, filters by title, year, type
	public String getByTitle(@RequestParam(name = "s", required = false) String title, @RequestParam(required = false, name = "year") String year, 
			@RequestParam(required = false, name = "type") String type, Model model) {
		if (title == null || title.isEmpty()) {
			String search = session.getAttribute("title").toString();
			String yearSearch = session.getAttribute("year").toString();
			String typeSearch = session.getAttribute("type").toString();
			List<Movie> movies = service.getSearch(search, yearSearch, typeSearch);
			model.addAttribute("movies", movies);
			return "listofmovies";
		} else {
			session.setAttribute("title", title);
			session.setAttribute("year", year);
			session.setAttribute("type", type);
			List<Movie> movies = service.getSearch(title, year, type);
			model.addAttribute("movies", movies);
			return "listofmovies";
		}
	}
	
	@RequestMapping ("/watchlist") // Watch list/favorites list
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
	
	@RequestMapping ("/movie-add") // Method to add movies to favorites
	public String addMovie(Movie movie) {
		User user = (User) session.getAttribute("user");
		user = userRepo.findById(user.getId()).get();
		movie.setUser(user);
		repository.save(movie);
		return ("redirect:/listofmovies");
	}
	
	@RequestMapping ("/watchlist/remove/{id}") // Method to remove movies from favorites
	public String removeMovie(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return "redirect:/watchlist";
	}
	
	@RequestMapping ("/moreinfo") // Method to pull brief description of movie
	public String getMoreInfo(@RequestParam("title") String title, Model model) {
		Movie movie = service.getMoreInfo(title);
		model.addAttribute("movie", movie);
		return "moreinfo";
	}
	@RequestMapping("/signup") // Sign-up page, prompts user to make account
	public String signUpForm() {
		
		return "signup-form";
	}
	
	
	@RequestMapping("/signup/submit") // Saves info to database
	public String signUpSubmit(User user) {
				
		userRepo.save(user);
		
		return "redirect:/";
	}
	
	@RequestMapping("/logout") // Logs out current user
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
