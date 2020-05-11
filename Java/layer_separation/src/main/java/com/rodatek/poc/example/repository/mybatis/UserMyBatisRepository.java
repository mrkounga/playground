package com.rodatek.poc.example.repository.mybatis;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rodatek.common.repository.mybatis.BaseMyBatisRepository;

@Mapper
public interface UserMyBatisRepository  extends BaseMyBatisRepository<UserEntity> {

	@Select("select * from MYUSERS")
	List<UserEntity> findAll();

	@Select("SELECT * FROM MYUSERS WHERE id = #{id}")
	Optional<UserEntity> findById(long id);
	
	@Select("SELECT * FROM MYUSERS WHERE email = #{email}")
	Optional<UserEntity> findByEmail(String email);

	@Delete("DELETE FROM MYUSERS WHERE id = #{id}")
	boolean deleteById(long id);

	@Insert("INSERT INTO MYUSERS(email, firstname,username) "
			+ " VALUES (#{email}, #{firstname}, #{username})")
	int save(UserEntity user);

	@Update("Update MYUSERS set email=#{email}, " + " firstname=#{firstname}, username=#{username} where id=#{id}")
	boolean update(UserEntity user);

	@Select("select count(*) from MYUSERS")
	int count();
	
	@Delete("DELETE  FROM MYUSERS")
	boolean deleteAll();
	

}
