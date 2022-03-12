package com.parkjonghun.springboot.tutorial.repository;

import com.parkjonghun.springboot.tutorial.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> { //<대상 엔티티, Id 타입>a
}
