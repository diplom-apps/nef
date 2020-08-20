package ru.server.nef.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.server.nef.entity.Article;
import ru.server.nef.repositories.ArticleRepository;

@RestController
public class RestArticleController {
    private ArticleRepository articleRepository;

    @Autowired
    public RestArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping(value = "/articles")
    public Iterable<Article> findAll(){
         return articleRepository.findAll();
    }
}
