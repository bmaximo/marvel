package br.com.bmaximo.marvel.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "characters")
public class Characters implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	private String name;
	
	private String description;
	
	private Date modified;
	
	private String resourceURI;
	
	private String thumbnail;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "characters_comics", 
	joinColumns = @JoinColumn(name = "characterId"), 
	inverseJoinColumns = @JoinColumn(name = "comicId"))
	private List<Comics> comics = new ArrayList<Comics>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "characters_stories", 
	joinColumns = @JoinColumn(name = "characterId"), 
	inverseJoinColumns = @JoinColumn(name = "storiesId"))
	private List<Stories> stories = new ArrayList<Stories>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "characters_events", 
	joinColumns = @JoinColumn(name = "characterId"), 
	inverseJoinColumns = @JoinColumn(name = "eventId"))
	private List<Events> events = new ArrayList<Events>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "characters_series", 
	joinColumns = @JoinColumn(name = "characterId"), 
	inverseJoinColumns = @JoinColumn(name = "serieId"))
	private List<Series> series = new ArrayList<Series>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getResourceURI() {
		return resourceURI;
	}

	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	public List<Comics> getComics() {
		return comics;
	}

	public void setComics(List<Comics> comics) {
		this.comics = comics;
	}

	public List<Stories> getStories() {
		return stories;
	}

	public void setStories(List<Stories> stories) {
		this.stories = stories;
	}

	public List<Events> getEvents() {
		return events;
	}

	public void setEvents(List<Events> events) {
		this.events = events;
	}

	public List<Series> getSeries() {
		return series;
	}

	public void setSeries(List<Series> series) {
		this.series = series;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Characters other = (Characters) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
