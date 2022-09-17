package com.url.app.service;

import com.url.app.model.Url;
import com.url.app.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.url.app.util.GenerateShortUrl.isUrlValid;
import static com.url.app.util.GenerateShortUrl.getShortUrl;

@Service
public class UrlService {
    @Autowired
    private UrlRepository urlRepository;

    public String getOriginalUrl(String id) {
        System.out.println("UrlService ..id "+id);
        return urlRepository.findByShorturl(id);
    }

    public Url generateShortUrl(String url) {
        System.out.println(url);
        if (!isUrlValid(url)) {
            System.out.println("URL is not valid");
            return null;
        }

        Url urlObject = new Url();
        urlObject.setOriginalurl(url);
        urlObject.setShorturl(getShortUrl(url));
        return urlRepository.save(urlObject);
    }
}
