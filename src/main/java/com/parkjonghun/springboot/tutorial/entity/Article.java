package com.parkjonghun.springboot.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//DB가 ID를 자동 생성.
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    public void patch(Article info) {
        if(info.title != null) this.title = info.title;
        if(info.content != null) this.content = info.content;
    }
}
