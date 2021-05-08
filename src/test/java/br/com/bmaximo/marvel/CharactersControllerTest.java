package br.com.bmaximo.marvel;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import br.com.bmaximo.marvel.entity.Characters;
import br.com.bmaximo.marvel.entity.Comics;
import br.com.bmaximo.marvel.entity.Events;
import br.com.bmaximo.marvel.entity.Series;
import br.com.bmaximo.marvel.entity.Stories;
import br.com.bmaximo.marvel.repository.CharactersRepository;

@AutoConfigureMockMvc
@SpringBootTest
public class CharactersControllerTest {
	
	private static final String DEFAULT_NAME = "Personagem teste";
	private static final String DEFAULT_DESCRIPTION = "descricao teste";
	private static final String DEFAULT_URI = "teste uri";
	private static final String DEFAULT_THUMBNAIL = "teste.jpg";
	private static final Date DEFAULT_MODIFIED = new Date();	 
	 
	@Autowired
	private CharactersRepository charactersRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
    private MockMvc restMockMvc;
	
	private Characters character;
	
	public static Characters createEntity(EntityManager entityManager) {
		Characters character = new Characters();
		character.setName(DEFAULT_NAME);
		character.setDescription(DEFAULT_DESCRIPTION);
		character.setModified(DEFAULT_MODIFIED);
		character.setResourceURI(DEFAULT_URI);
		character.setThumbnail(DEFAULT_THUMBNAIL);
		
		Comics comic = new Comics();
		comic.setDescription(DEFAULT_DESCRIPTION);
		comic.setModified(DEFAULT_MODIFIED);
		character.getComics().add(comic);
		
		Events event = new Events();
		event.setDescription(DEFAULT_DESCRIPTION);
		event.setModified(DEFAULT_MODIFIED);
		character.getEvents().add(event);
		
		Series serie = new Series();
		serie.setDescription(DEFAULT_DESCRIPTION);
		serie.setModified(DEFAULT_MODIFIED);
		character.getSeries().add(serie);
		
		Stories story = new Stories();
		story.setDescription(DEFAULT_DESCRIPTION);
		story.setModified(DEFAULT_MODIFIED);
		character.getStories().add(story);
		
		return character;
	}
	
	public static Characters initTestCharacter(CharactersRepository charactersRepository, EntityManager entityManager) {
		Characters character = createEntity(entityManager);
		return character;
	}
	
	@BeforeEach
    public void initTest() {
		character = initTestCharacter(charactersRepository, entityManager);
    }
	
	@Test
    @Transactional
    void findAll() throws Exception {
		charactersRepository.saveAndFlush(character);
		restMockMvc.perform(get("/v1/public/characters").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$").isArray());
	}
	
	@Test
    @Transactional
    void findById() throws Exception {
		charactersRepository.saveAndFlush(character);
		restMockMvc
			.perform(get("/v1/public/characters/{id}", character.getId()))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(jsonPath("$.name", is(DEFAULT_NAME)))
			.andExpect(jsonPath("$.description", is(DEFAULT_DESCRIPTION)))
			.andExpect(jsonPath("$.modified", is(notNullValue())))
			.andExpect(jsonPath("$.resourceURI", is(DEFAULT_URI)))
			.andExpect(jsonPath("$.thumbnail", is(DEFAULT_THUMBNAIL)))
			.andExpect(jsonPath("$.comics").isArray())
			.andExpect(jsonPath("$.events").isArray())
			.andExpect(jsonPath("$.series").isArray())
			.andExpect(jsonPath("$.stories").isArray());
	}
	
	@Test
    @Transactional
    void getNotFound() throws Exception {
		restMockMvc.perform(get("/v1/public/characters/0")).andExpect(status().isNotFound());
	}
	
	@Test
    @Transactional
    void getBadRequest() throws Exception {
		restMockMvc.perform(get("/v1/public/characters/unknow")).andExpect(status().isBadRequest());
	}
	
	@Test
    @Transactional
    void findComics() throws Exception {
		charactersRepository.saveAndFlush(character);
		restMockMvc
			.perform(get("/v1/public/characters/{id}/comics", character.getId()))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(jsonPath("$").isArray());
	}
	
	@Test
    @Transactional
    void findEvents() throws Exception {
		charactersRepository.saveAndFlush(character);
		restMockMvc
			.perform(get("/v1/public/characters/{id}/events", character.getId()))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(jsonPath("$").isArray());
	}
	
	@Test
    @Transactional
    void findSeries() throws Exception {
		charactersRepository.saveAndFlush(character);
		restMockMvc
			.perform(get("/v1/public/characters/{id}/series", character.getId()))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(jsonPath("$").isArray());
	}
	
	@Test
    @Transactional
    void findStories() throws Exception {
		charactersRepository.saveAndFlush(character);
		restMockMvc
			.perform(get("/v1/public/characters/{id}/stories", character.getId()))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(jsonPath("$").isArray());
	}

}
