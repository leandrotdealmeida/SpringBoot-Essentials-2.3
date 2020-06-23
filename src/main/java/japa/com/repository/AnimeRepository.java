package japa.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import japa.com.domain.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Integer>{
	
	List<Anime> findByName(String name);
}
