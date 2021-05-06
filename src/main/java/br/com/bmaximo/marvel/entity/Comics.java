package br.com.bmaximo.marvel.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comics")
public class Comics implements Serializable {
	
//	creators	ResourceList	A resource list containing the creators associated with this comic.
//	characters	ResourceList	A resource list containing the characters which appear in this comic.
//	stories	ResourceList	A resource list containing the stories which appear in this comic.
//	events	ResourceList	A resource list containing the events in which this comic appears.
	
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	private Integer digitalId;
	
	private String title;
	
	private Integer issueNumber;
	
	private String variantDescription;
	
	private String description;
	
	private Date modified;
	
	private String isbn;
	
	private String upc;
	
	private String diamondCode;
	
	private String ean;
	
	private String issn;
	
	private String format;
	
	private Integer pageCount;
	
	private String textObjects;
	
	private String resourceURI;
	
//	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinTable(name = "rl_characters_comics", 
//	joinColumns = @JoinColumn(name = "comicId"), 
//	inverseJoinColumns = @JoinColumn(name = "characterId"))
//	private List<Characters> characters;
//
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

	public Integer getDigitalId() {
		return digitalId;
	}

	public void setDigitalId(Integer digitalId) {
		this.digitalId = digitalId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(Integer issueNumber) {
		this.issueNumber = issueNumber;
	}

	public String getVariantDescription() {
		return variantDescription;
	}

	public void setVariantDescription(String variantDescription) {
		this.variantDescription = variantDescription;
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getDiamondCode() {
		return diamondCode;
	}

	public void setDiamondCode(String diamondCode) {
		this.diamondCode = diamondCode;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public String getTextObjects() {
		return textObjects;
	}

	public void setTextObjects(String textObjects) {
		this.textObjects = textObjects;
	}

	public String getResourceURI() {
		return resourceURI;
	}

	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
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
		Comics other = (Comics) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
