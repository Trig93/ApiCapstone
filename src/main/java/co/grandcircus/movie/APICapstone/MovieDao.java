package co.grandcircus.movie.APICapstone;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository <Movie, Long> {

	List<Movie> findByUserId(Long id);

}
