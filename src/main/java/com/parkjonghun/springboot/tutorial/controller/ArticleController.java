package com.parkjonghun.springboot.tutorial.controller;

import com.parkjonghun.springboot.tutorial.dto.ArticleDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @GetMapping("/articles/new")
    public String getNewArticle() {
        return "articles/new";
    }

    @PostMapping("/articles/post")
    public String postNewArticle(ArticleDto form) {
        System.out.println(form.toString());
        return "";
    }
}
