package spring_mybatis;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.rodatek.poc.mybatis.Article;
import com.rodatek.poc.mybatis.ArticleMapper;
import com.rodatek.poc.mybatis.PersistenceConfig;

import lombok.extern.log4j.Log4j2;


@ContextConfiguration(classes = PersistenceConfig.class)
@SpringJUnitConfig
@Log4j2
public class ArticleMapperIntegrationTest {
 
    @Autowired
    ArticleMapper articleMapper;
 
    @Test
    void whenRecordsInDatabase_shouldReturnArticleWithGivenId() {
    	//Arrange
        Article article;
        
        //Act
        article = articleMapper.getArticle(1);
         
        //assert
        //assertThat(Ass)
        assertThat(article).isNotNull();
        assertThat(article.getId()).isEqualTo(1);
        assertThat(article.getAuthor()).isEqualTo("Baeldung");
        assertThat(article.getTitle()).isEqualTo("Working with MyBatis in Spring");
    }
    
    @Test
    void givenAnArticle_whenCreateIt_theReturnObjectMatchTheCreatedOne() 
    {
    	//Arrange
    	Article article= Article.builder()
    			.id(10)
    			.author("Uriel")
    			.title("The Bible book")
    			.build();      
    	
    	//Act
    	articleMapper.createArticle(article);
    	
    	//Assert 
    	Article foundArticle=articleMapper.getArticle(10); 	   	
    	assertThat(article).isEqualTo(foundArticle);
    }
   
  @Test
   void update() {
	   //given Article
	   Article article= Article.builder()
   			.id(5)
   			.author("Kounga Raoul")
   			.title("The Bible book")
   			.build();
	   
      //Act	  
      boolean isUpdated=articleMapper.updateArticle(article);
            
      //Assert
      assertThat(isUpdated).isEqualTo(Boolean.TRUE);      
   }
   
   @Test
   void deleteArticle () {
	   
	   //Arrange
        boolean isDeleted;
        Integer articleId=3;
       
       //Act
       isDeleted = articleMapper.deleteById(articleId);
       
       //Assert
       assertThat(isDeleted).isEqualTo(Boolean.TRUE);  
   }
   
   
   @Test
   void count() {
	   //arrange
	   
	   //act
	   int counted = articleMapper.count();
	   
	   //assert
	   assertThat(counted).isGreaterThan(0);
	  
   }
}