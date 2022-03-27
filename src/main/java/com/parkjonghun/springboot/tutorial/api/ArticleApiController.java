package com.parkjonghun.springboot.tutorial.api;

import com.parkjonghun.springboot.tutorial.dto.ArticleDto;
import com.parkjonghun.springboot.tutorial.entity.Article;
import com.parkjonghun.springboot.tutorial.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ArticleApiController {

    @Autowired
    private ArticleRepository repository;

    //Get
    @GetMapping("/api/articles")
    public List<Article> getArticles() {
        return (List<Article>)repository.findAll();
    }

    @GetMapping("/api/articles/{id}")
    public Article getArticle(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    //Post
    @PostMapping("/api/articles")
    public Article postArticle(@RequestBody ArticleDto dto) {
        Article target = dto.toEntity();
        return repository.save(target);
    }

    //Put
    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> putArticle(@PathVariable Long id, @RequestBody ArticleDto dto) {
        Article info = dto.toEntity();
        Article target = repository.findById(id).orElse(null);
        if(target == null || !id.equals(info.getId()) || info.getTitle() == null || info.getContent() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(target));
    }

    //Patch
    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> patchArticle(@PathVariable Long id, @RequestBody ArticleDto dto) {
        Article info = dto.toEntity();
        Article target = repository.findById(id).orElse(null);
        if(target == null || !id.equals(info.getId()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        target.patch(info);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(target));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> deleteArticle(@PathVariable Long id) {
        Article target = repository.findById(id).orElse(null);
        if(target == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        repository.delete(target);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
