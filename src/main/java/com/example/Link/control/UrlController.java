package com.example.Link.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Link.entity.Url;
import com.example.Link.service.UrlService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173") 
public class UrlController
{

    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody Map<String, String> body) 
    {
        String longUrl = body.get("url");
        String shortCode = urlService.shortenUrl(longUrl);
//        return ResponseEntity.ok("http://JKly/s/" + shortCode);
        return ResponseEntity.ok("http://localhost:8089/s/" + shortCode);
    }
    
    @GetMapping("/getAll")
    public List<Url> get()
    {
    	return urlService.getAll();
    }

}
