package com.gapsi.crud.resources.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.gapsi.crud.resources.entity.Article;
import com.gapsi.crud.resources.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/article")
@Api(value = "Article Resource REST Endpoint", description = "CRUD ARTICLES(Create,Read,Update and Delete)")
public class ArticleController {

    @Autowired
    private ArticleService service;

    @ApiOperation(value = "Agrega un articulo")
    @ApiResponses(
            value = {                    
                    @ApiResponse(code = 200, message = "Successful Operation")
            }
    )
    @PostMapping("/addArticle")
    public Article addArticle(@RequestBody Article Article) {
        return service.saveArticle(Article);
    }

    @ApiOperation(value = "Agrega un congunto de articulos")
    @ApiResponses(
            value = {                    
                    @ApiResponse(code = 200, message = "Successful Operation")
            }
    )
    @PostMapping("/addArticles")
    public List<Article> addArticles(@RequestBody List<Article> Articles) {
        return service.saveArticles(Articles);
    }

    @ApiOperation(value = "Lista todos los articulos existentes")
    @ApiResponses(
            value = {                    
                    @ApiResponse(code = 200, message = "Successful Operation")
            }
    )
    
    @GetMapping("/findAllArticles")
    public List<Article> findAllArticles() {
        return service.getArticles();
    }

    @ApiOperation(value = "Busca un articulo por su identificador{id}")
    @ApiResponses(
            value = {                    
                    @ApiResponse(code = 200, message = "Successful Operation")
            }
    )
    @GetMapping("/findArticleById/{id}")
    public Article findArticleById(@PathVariable int id) {
        return service.getArticleById(id);
    }

    @ApiOperation(value = "Busca un articulo por su nombre{name}")
    @ApiResponses(
            value = {                    
                    @ApiResponse(code = 200, message = "Successful Operation")
            }
    )
    @GetMapping("/findArticleByName/{name}")
    public Article findArticleByName(@PathVariable String name) {
        return service.getArticleByName(name);
    }

    @ApiOperation(value = "Actualiza descripcion, precio y/o modelo del articulo")
    @ApiResponses(
            value = {                    
                    @ApiResponse(code = 200, message = "Successful Operation")
            }
    )
    @PutMapping("/updateArticle")
    public Article updateArticle(@RequestBody Article Article) {
        return service.updateArticle(Article);
    }

    @ApiOperation(value = "Elimina un articulo por su identificador{id}")
    @ApiResponses(
            value = {                    
                    @ApiResponse(code = 200, message = "Successful Operation")
            }
    )
    @DeleteMapping("/deleteArticle/{id}")
    @Transactional
    public String deleteArticle(@PathVariable int id) {
        return service.deleteArticle(id);
    }
}