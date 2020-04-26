package com.rodatek.poc.mybatis;

import lombok.Builder;
import lombok.Value;

@Value @Builder
public class Article {
	private final Integer id;
    private final String title;
    private final String author;
    
    public Article(Integer id, String title, String author) {
    	this.id = id;
    	this.title = title;
    	this.author = author;
    }
}
