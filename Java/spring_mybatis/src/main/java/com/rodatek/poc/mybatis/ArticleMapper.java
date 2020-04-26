package com.rodatek.poc.mybatis;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ArticleMapper {
	
	//select
	@Select("SELECT * FROM ARTICLES WHERE id = #{id}")
    Article getArticle(@Param("id") Integer id);
	
	
	//insert
	@Insert("INSERT INTO ARTICLES(id, title, author) VALUES(#{id}, #{title},#{author})")
	void createArticle(Article article);
	
	//update
	@Update("UPDATE ARTICLES SET title = #{title}, author = #{author} where id = #{id}")
	boolean updateArticle(Article article);

	//delete
	@Delete("DELETE FROM ARTICLES WHERE id = #{id}")
    boolean deleteById(@Param("id") Integer id);
	
	//count
	@Select("Select count(*) from Articles")
	int count();
	
	
	

}
