package br.com.bmaximo.marvel.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bmaximo.marvel.entity.Characters;

@Repository
public interface CharactersRepository extends JpaRepository<Characters, Integer>{
	
	Page<Characters> findAll(Pageable pageable);
	
	Optional<Characters> findById(Integer id);

}
