package com.example.Link.control;


import com.example.Link.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class RedirectController
{

    @Autowired
    private UrlService urlService;

    @GetMapping("/s/{code}")
    public void redirectToOriginal(@PathVariable String code, HttpServletResponse response) throws IOException
    {
        String originalUrl = urlService.getOriginalUrl(code);
        response.sendRedirect(originalUrl);
    }
}

