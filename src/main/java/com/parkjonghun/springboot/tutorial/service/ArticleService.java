package com.parkjonghun.springboot.tutorial.service;

import com.parkjonghun.springboot.tutorial.dto.ArticleDto;
import com.parkjonghun.springboot.tutorial.entity.Article;
import com.parkjonghun.springboot.tutorial.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ArticleService {

    @Autowired
    private ArticleRepository repository;

    public List<Article> getArticles() {
        return (List<Article>)repository.findAll();
    }

    public Article getArticle(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Article postArticle(ArticleDto dto) {
        Article target = dto.toEntity();
        if(target.getId() != null) {
            return null;
        }
        return repository.save(target);
    }

    public Article putArticle(Long id, ArticleDto dto) {
        Article info = dto.toEntity();
        Article target = repository.findById(id).orElse(null);
        if(target == null || !id.equals(info.getId()) || info.getTitle() == null || info.getContent() == null)
            return null;
        return repository.save(target);
    }

    public Article patchArticle(Long id, ArticleDto dto) {
        Article info = dto.toEntity();
        Article target = repository.findById(id).orElse(null);
        if(target == null || !id.equals(info.getId()))
            return null;
        target.patch(info);
        return repository.save(target);
    }

    public Article deleteArticle(Long id) {
        Article target = repository.findById(id).orElse(null);
        if(target == null) return null;
        repository.delete(target);
        return target;
    }
}
