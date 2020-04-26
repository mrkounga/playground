package com.rodatek.poc.mybatis;

import java.io.Serializable;

import javax.persistence.Id;

import tk.mybatis.mapper.annotation.KeySql;

public class Country implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String countryname;
    private String countrycode;

}
