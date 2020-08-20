package ru.server.nef.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.server.nef.entity.Article;
import ru.server.nef.repositories.ArticleRepository;

import javax.validation.Valid;

@Controller
public class ArticleController {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    @GetMapping(value = "/article/add")
    public String showForm(Article article) {
        return "add_article";
    }

    @PostMapping(value = "/article/add")
    public String addRequest(@ModelAttribute("article") @Valid Article article,
                             BindingResult bindingResult)
    {
        System.out.println("article");
        if (bindingResult.hasErrors()){
            System.out.println("article");
            return "add_article";
        }
        System.out.println("article");
        articleRepository.save(article);
        return "redirect:/article/add";
    }

}
