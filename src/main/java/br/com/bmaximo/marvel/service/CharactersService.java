package br.com.bmaximo.marvel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.bmaximo.marvel.entity.Characters;
import br.com.bmaximo.marvel.repository.CharactersRepository;
import br.com.bmaximo.marvel.service.interfaces.CharactersServiceInterface;

@Service
public class CharactersService implements CharactersServiceInterface{

	@Autowired
	private CharactersRepository charactersRepository;

	@Override
	public List<Characters> findAll(Pageable pageable) {
		return this.charactersRepository.findAll(pageable).getContent();
	}

	@Override
	public Optional<Characters> findById(Integer id) {
		return this.charactersRepository.findById(id);
	}

}
