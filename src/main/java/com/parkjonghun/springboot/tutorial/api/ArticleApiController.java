package com.parkjonghun.springboot.tutorial.api;

import com.parkjonghun.springboot.tutorial.dto.ArticleDto;
import com.parkjonghun.springboot.tutorial.entity.Article;
import com.parkjonghun.springboot.tutorial.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ArticleApiController {

    @Autowired
    private ArticleService service;

    @GetMapping("/api/articles")
    public ResponseEntity<List<Article>> getArticles() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getArticles());
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getArticle(id));
    }

    @PostMapping("/api/articles")
    public ResponseEntity<Article> postArticle(@RequestBody ArticleDto dto) {
        Article target = service.postArticle(dto);
        return (target != null) ? ResponseEntity.status(HttpStatus.CREATED).body(target) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> putArticle(@PathVariable Long id, @RequestBody ArticleDto dto) {
        Article target = service.putArticle(id, dto);
        return (target == null) ? ResponseEntity.status(HttpStatus.BAD_REQUEST).build() : ResponseEntity.status(HttpStatus.OK).body(target);
    }

    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> patchArticle(@PathVariable Long id, @RequestBody ArticleDto dto) {
        Article target = service.patchArticle(id, dto);
        return (target == null) ? ResponseEntity.status(HttpStatus.BAD_REQUEST).build() :
         ResponseEntity.status(HttpStatus.OK).body(target);
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> deleteArticle(@PathVariable Long id) {
        Article target = service.deleteArticle(id);
        return (target == null) ? ResponseEntity.status(HttpStatus.BAD_REQUEST).build() : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
