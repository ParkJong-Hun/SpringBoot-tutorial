package com.parkjonghun.springboot.tutorial.dto;

import com.parkjonghun.springboot.tutorial.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleDto {
    private Long id; //id 추가
    private String title;
    private String content;

    public Article toEntity() { return new Article(id, title, content); }
}
