package com.example.Link.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Link.entity.Url;
import com.example.Link.repository.UrlRepositorys;


@Service
public class UrlService {

    @Autowired
    private UrlRepositorys urlRepository;
    
    public List<Url> getAll()
    {
    	return urlRepository.findAll();
    }

    public String shortenUrl(String originalUrl) 
    {
        String shortCode = UUID.randomUUID().toString().substring(0, 6);
        Url url = new Url();
        url.setOriginalUrl(originalUrl);
        url.setShortCode(shortCode);
        urlRepository.save(url);
        return shortCode;
    }

    public String getOriginalUrl(String shortCode)
    {
        return urlRepository.findByShortCode(shortCode)
                .map(Url::getOriginalUrl)
                .orElseThrow(() -> new RuntimeException("Short URL not found"));
    }
}