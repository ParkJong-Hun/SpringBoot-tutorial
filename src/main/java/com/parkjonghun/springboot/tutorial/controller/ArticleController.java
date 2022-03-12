package com.parkjonghun.springboot.tutorial.controller;

import com.parkjonghun.springboot.tutorial.dto.ArticleDto;
import com.parkjonghun.springboot.tutorial.entity.Article;
import com.parkjonghun.springboot.tutorial.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @Autowired //DI
    private ArticleRepository repository;

    @GetMapping("/articles/new")
    public String getNewArticle() {
        return "articles/new";
    }

    @PostMapping("/articles/post")
    public String postNewArticle(ArticleDto form) {
        System.out.println(form.toString());

        Article entity = form.toEntity();//DTO를 Entity로 변환
        System.out.println(entity);

        Article savedDataOnDatabase = repository.save(entity);//Entity를 Repository를 이용해 데이터베이스에 저장
        System.out.println(savedDataOnDatabase);
p
        return "";
    }
}
