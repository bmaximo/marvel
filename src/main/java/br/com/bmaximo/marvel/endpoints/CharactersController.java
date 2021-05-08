package br.com.bmaximo.marvel.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.bmaximo.marvel.entity.Characters;
import br.com.bmaximo.marvel.entity.Comics;
import br.com.bmaximo.marvel.entity.Events;
import br.com.bmaximo.marvel.entity.Series;
import br.com.bmaximo.marvel.entity.Stories;
import br.com.bmaximo.marvel.service.CharactersService;

@RestController
@RequestMapping("/v1/public")
public class CharactersController {

	@Autowired
	private CharactersService charactersService;
	
	@GetMapping("/characters")
    public ResponseEntity<Iterable<Characters>> findAll(Pageable pageable) {
		return new ResponseEntity<Iterable<Characters>>(this.charactersService.findAll(pageable), HttpStatus.OK);
	}
	
	@GetMapping("/characters/{id}")
    public Characters findById(@PathVariable Integer id) {
		return this.charactersService.findById(id)
                .orElseThrow(() -> 
                	new ResponseStatusException(HttpStatus.NOT_FOUND, "Character does not exists!")
                );
	}
	
	@GetMapping("/characters/{id}/comics")
	public ResponseEntity<Iterable<Comics>> findComics(@PathVariable Integer id) {
		Characters characters =  this.charactersService.findById(id).orElse(null);
		if(characters != null) {
			return new ResponseEntity<Iterable<Comics>>(characters.getComics(), HttpStatus.OK);
		} 
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/characters/{id}/events")
	public ResponseEntity<Iterable<Events>> findEvents(@PathVariable Integer id) {
		Characters characters =  this.charactersService.findById(id).orElse(null);
		if(characters != null) {
			return new ResponseEntity<Iterable<Events>>(characters.getEvents(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/characters/{id}/series")
	public ResponseEntity<Iterable<Series>> findSeries(@PathVariable Integer id) {
		Characters characters =  this.charactersService.findById(id).orElse(null);
		if(characters != null) {
			return new ResponseEntity<Iterable<Series>>(characters.getSeries(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/characters/{id}/stories")
	public ResponseEntity<Iterable<Stories>> findStories(@PathVariable Integer id) {
		Characters characters =  this.charactersService.findById(id).orElse(null);
		if(characters != null) {
			return new ResponseEntity<Iterable<Stories>>(characters.getStories(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
