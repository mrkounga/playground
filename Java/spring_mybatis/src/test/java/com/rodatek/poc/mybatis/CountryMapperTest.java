package com.rodatek.poc.mybatis;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class CountryMapperTest {
	
	@Autowired
	private static CountryMapper countryMapper;
	
	@BeforeAll
	static void testInitializationMapper() {
		assertThat(countryMapper).isNotNull();
	}

	@Test
	void testSelectOne() {
		countryMapper.selectAll().stream().forEach(e -> System.out.println(e.toString()));
		
	}

	@Test
	void testSelect() {
		//fail("Not yet implemented");
	}

	@Test
	void testSelectAll() {
		//fail("Not yet implemented");
	}

	@Test
	void testSelectCount() {
		//fail("Not yet implemented");
	}

	@Test
	void testSelectByPrimaryKey() {
		//fail("Not yet implemented");
	}

	@Test
	void testExistsWithPrimaryKey() {
		//fail("Not yet implemented");
	}

	@Test
	void testInsert() {
		//fail("Not yet implemented");
	}

	@Test
	void testInsertSelective() {
		//fail("Not yet implemented");
	}

	@Test
	void testUpdateByPrimaryKey() {
		//fail("Not yet implemented");
	}

	@Test
	void testUpdateByPrimaryKeySelective() {
	//	fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		//fail("Not yet implemented");
	}

	@Test
	void testDeleteByPrimaryKey() {
		//fail("Not yet implemented");
	}

	@Test
	void testSelectByExample() {
		//fail("Not yet implemented");
	}

	@Test
	void testSelectOneByExample() {
		//fail("Not yet implemented");
	}

	@Test
	void testSelectCountByExample() {
		//fail("Not yet implemented");
	}

	@Test
	void testDeleteByExample() {
		//fail("Not yet implemented");
	}

	@Test
	void testUpdateByExample() {
		//fail("Not yet implemented");
	}

	@Test
	void testUpdateByExampleSelective() {
		//fail("Not yet implemented");
	}

	@Test
	void testSelectByExampleAndRowBounds() {
		//fail("Not yet implemented");
	}

	@Test
	void testSelectByRowBounds() {
		//fail("Not yet implemented");
	}

}
