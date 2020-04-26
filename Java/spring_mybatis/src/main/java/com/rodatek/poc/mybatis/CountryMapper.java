package com.rodatek.poc.mybatis;

import org.mybatis.spring.annotation.MapperScan;

import tk.mybatis.mapper.common.Mapper;

@MapperScan
public interface CountryMapper extends Mapper<Country>{

}
