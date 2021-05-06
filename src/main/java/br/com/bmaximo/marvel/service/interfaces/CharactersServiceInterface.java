package br.com.bmaximo.marvel.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import br.com.bmaximo.marvel.entity.Characters;

public interface CharactersServiceInterface {
	
	List<Characters> findAll(Pageable pageable);
	
	Optional<Characters> findById(Integer id);

}
