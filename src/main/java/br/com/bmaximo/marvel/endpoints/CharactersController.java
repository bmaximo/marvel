package br.com.bmaximo.marvel.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bmaximo.marvel.entity.Characters;
import br.com.bmaximo.marvel.entity.Comics;
import br.com.bmaximo.marvel.service.CharactersService;

@RestController
@RequestMapping("/v1/public")
public class CharactersController {

	@Autowired
	private CharactersService charactersService;
	
	@GetMapping("/characters")
    public Iterable<Characters> findAll(Pageable pageable) {
		return this.charactersService.findAll(pageable);
	}
	
	@GetMapping("/characters/{id}")
    public Characters findById(@PathVariable Integer id) {
		 return this.charactersService.findById(id).orElse(null);
	}
	
	@GetMapping("/characters/{id}/comics")
	public Iterable<Comics> findComics(@PathVariable Integer id) {
		Characters characters =  this.charactersService.findById(id).orElse(null);
		if(characters != null) {
			return characters.getComics();
		}
		return null;
	}

}
