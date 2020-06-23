package japa.com.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import japa.com.domain.Anime;
import japa.com.repository.AnimeRepository;
import japa.com.util.Utils;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AnimeService {

	private final Utils utils;
	private final AnimeRepository animeRepository;

	public List<Anime> listAll() {
		return animeRepository.findAll();
	}
	
	public List<Anime> findByName(String name) {
		return animeRepository.findByName(name);
	}
	
	public Anime findById(int id) {
		return utils.findAnimeOrThrowNotFound(id, animeRepository);
	}

	public Anime save(Anime anime) {
		return animeRepository.save(anime);
	}

	public void delete(int id) {
		animeRepository.delete(utils.findAnimeOrThrowNotFound(id, animeRepository));

	}

	public void update(Anime anime) {
		animeRepository.save(anime);
	}
}
