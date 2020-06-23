package japa.com.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import japa.com.domain.Anime;
import japa.com.repository.AnimeRepository;

@Component
public class Utils {

	public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime) {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd- HH:mm:ss").format(localDateTime);
	}

	public Anime findAnimeOrThrowNotFound(int id, AnimeRepository animeRepository) {
		return animeRepository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime not found"));
	}
}
