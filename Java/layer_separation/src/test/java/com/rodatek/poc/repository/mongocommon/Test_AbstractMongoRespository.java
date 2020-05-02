package com.rodatek.poc.repository.mongocommon;

import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.rodatek.common.persistence.mongo.MongoEntity;

@SpringJUnitConfig
@DataMongoTest
public class Test_AbstractMongoRespository<E extends MongoEntity> {

}
