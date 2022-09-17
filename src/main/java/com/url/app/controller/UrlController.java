package com.url.app.controller;

import com.url.app.model.Url;
import com.url.app.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class UrlController {
    @Autowired
    private UrlService urlService;

    @PostMapping
    public Url generateShortUrl(@RequestBody String url) {
        System.out.println("Generate short URL for ...");
        return urlService.generateShortUrl(url);
    }

    @GetMapping("/{shortLink}")
    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortLink, HttpServletResponse response)
            throws IOException {
        System.out.println("Redirect to Original  URL ...shortLink  "+shortLink);
        response.sendRedirect(urlService.getOriginalUrl(shortLink));
        return null;
    }
}
