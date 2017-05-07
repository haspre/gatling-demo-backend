package com.unic.gatling.unicorns.mappers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.unic.gatling.unicorns.mappers.Gender.female;
import static com.unic.gatling.unicorns.mappers.UnicornBuilder.anyFemaleUnicorn;
import static com.unic.gatling.unicorns.mappers.UnicornBuilder.anyFemaleUnicornBuilder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@MybatisTest
public class UnicornMapperTest {

    @Autowired
    private UnicornMapper unicornMapper;

    @Test
    public void createAndRead() {

        long id = unicornMapper.create(anyFemaleUnicorn());

        Unicorn copyFromDB = unicornMapper.findOneById(id);
        assertThat(copyFromDB, notNullValue());
    }

    @Test
    public void findAll() {

        List<Unicorn> allUnicorns = unicornMapper.findAll();

        assertThat(allUnicorns, not(empty()));
    }

    @Test
    public void filterByAgeAndGender() {

        Unicorn youngUnicorn = anyFemaleUnicornBuilder()
                .withAge(35)
                .build();
        unicornMapper.create(youngUnicorn);

        List<Unicorn> youngUnicorns = unicornMapper.filterByMaxAgeAndGender(35, female);

        assertThat(youngUnicorns, not(empty()));
    }

}