package com.parkjonghun.springboot.tutorial.controller;

import com.parkjonghun.springboot.tutorial.dto.ArticleDto;
import com.parkjonghun.springboot.tutorial.entity.Article;
import com.parkjonghun.springboot.tutorial.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class ArticleController {
    @Autowired
    private ArticleRepository repository;

    @GetMapping("/articles/new")
    public String getNewArticle() {
        return "articles/new";
    }

    @PostMapping("/articles/post")
    public String postNewArticle(ArticleDto form) {
        log.info(form.toString());

        Article entity = form.toEntity();
        log.info(entity.toString());

        Article savedDataOnDatabase = repository.save(entity);
        log.info(savedDataOnDatabase.toString());

        return "redirect:/articles/" + savedDataOnDatabase.getId();
    }

    @GetMapping("/articles/{id}")
    public String getShowArticle(@PathVariable Long id, Model model) {
        log.info("id: " + id);

        Article entity = repository.findById(id).orElse(null);

        model.addAttribute("article", entity);

        return "articles/show";
    }

    @GetMapping("/articles")
    public String getIndex(Model model) {
        List<Article> entityList = (List<Article>)repository.findAll();

        model.addAttribute("articleList", entityList);

        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String putArticle(@PathVariable Long id, Model model) {
        Article entity = repository.findById(id).orElse(null);
        model.addAttribute("article", entity);
        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String patchArticle(ArticleDto form) {
        log.info(form.toString());

        Article edited = form.toEntity();
        log.info(edited.toString());

        Article target = repository.findById(edited.getId()).orElse(null);
        if(target != null) {
            repository.save(edited);
        }
        return "redirect:/articles/" + edited.getId();
    }
}
