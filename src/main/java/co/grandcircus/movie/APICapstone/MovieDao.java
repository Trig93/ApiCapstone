package co.grandcircus.movie.APICapstone;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository <Movie, Long> {

}
