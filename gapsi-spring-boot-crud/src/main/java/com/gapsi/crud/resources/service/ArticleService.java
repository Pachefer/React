package com.gapsi.crud.resources.service;

import com.gapsi.crud.resources.entity.Article;
import com.gapsi.crud.resources.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository repository;

    public Article saveArticle(Article article) {
        return repository.save(article);
    }

    public List<Article> saveArticles(List<Article> articles) {
    //    return repository.saveAll(articles);
    	return articles;
    }

    public List<Article> getArticles() {
        return repository.findAll();
    }

    public Article getArticleById(int id) {
    	return repository.findById(id);
    }

    public Article getArticleByName(String name) {
        return repository.findByName(name);
    }

    public String deleteArticle(int id) {
        repository.deleteById(id);
        return "Article " + id + ", removed !!! ";
    }

    public Article updateArticle(Article article) {
        Article existingArticle = repository.findById(article.getId());
        existingArticle.setDescription(article.getDescription());
        existingArticle.setModel(article.getModel());
        existingArticle.setPrice(article.getPrice());
        return repository.save(existingArticle);
    }


}
