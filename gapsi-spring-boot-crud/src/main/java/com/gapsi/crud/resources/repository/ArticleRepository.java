package com.gapsi.crud.resources.repository;

import com.gapsi.crud.resources.entity.Article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Integer> {
    
	Article save(Article article);

    //List<Article> saveAll(List<Article> articles);

    List<Article> findAll();

    Article findById(int id);

    Article findByName(String name);
    
    String deleteById(int id);
}

