package br.com.bmaximo.marvel.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stories")
public class Stories implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	private String title;
	
	private String description;
	
	private String resourceURI;
	
	private String type;
	
	private Date modified;
	
//	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinTable(name = "rl_characters_stories", 
//	joinColumns = @JoinColumn(name = "storieId"), 
//	inverseJoinColumns = @JoinColumn(name = "characterId"))
//	private List<Characters> characters;
	
//	comics	ComicList	A resource list containing comics in which this story takes place.
//	series	SeriesList	A resource list containing series in which this story appears.
//	events	EventList	A resource list of the events in which this story appears.


//	public List<Characters> getCharacters() {
//		return characters;
//	}
//
//	public void setCharacters(List<Characters> characters) {
//		this.characters = characters;
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResourceURI() {
		return resourceURI;
	}

	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		Stories other = (Stories) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
