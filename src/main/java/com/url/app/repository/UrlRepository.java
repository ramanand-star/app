package com.url.app.repository;

import com.url.app.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UrlRepository extends JpaRepository<Url, Integer> {

    @Query(value = "select originalurl from url u where shorturl = ?1", nativeQuery = true)
    String findByShorturl(String id);
    //String findById(int id);
    //String findByShorturl(String id);

}
