package japa.com.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import japa.com.domain.Anime;
import japa.com.service.AnimeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("animes")
@RequiredArgsConstructor
public class AnimeController {

	// @Autowired
	//private final Utils dateUtil;
	private final AnimeService animeService;

	@GetMapping
	public ResponseEntity<List<Anime>> listAll() {
		return ResponseEntity.ok(animeService.listAll());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Anime> findById(@PathVariable int id) {
		return ResponseEntity.ok(animeService.findById(id));
	}

	@GetMapping(path = "/find")
	public ResponseEntity<List<Anime>> findByName(@RequestParam("name") String name) {
		return ResponseEntity.ok(animeService.findByName(name));
	}

	@PostMapping
	public ResponseEntity<Anime> save(@RequestBody Anime anime) {
		return ResponseEntity.ok(animeService.save(anime));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		animeService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Anime anime) {
		animeService.update(anime);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
