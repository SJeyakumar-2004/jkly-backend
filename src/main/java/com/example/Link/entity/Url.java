package com.example.Link.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "urls")  
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(length = 2048)
    private String originalUrl;

    @Column(unique = true)
    private String shortCode;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOriginalUrl() 
	{
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) 
	{
		this.originalUrl = originalUrl;
	}

	public String getShortCode() 
	{
		return shortCode;
	}

	public void setShortCode(String shortCode) 
	{
		this.shortCode = shortCode;
	}

   
}
