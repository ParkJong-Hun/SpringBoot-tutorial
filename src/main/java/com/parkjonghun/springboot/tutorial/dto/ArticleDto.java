package com.parkjonghun.springboot.tutorial.dto;

import com.parkjonghun.springboot.tutorial.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleDto {
    private String title;
    private String content;

    public Article toEntity() { return new Article(null, title, content); }
}
