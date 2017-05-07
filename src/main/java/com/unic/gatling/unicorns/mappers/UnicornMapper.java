package com.unic.gatling.unicorns.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

@Mapper
public interface UnicornMapper {

    @Insert("insert into unicorns (firstName, lastName, age, gender) values (#{firstName}, #{lastName}, #{age}, #{gender})")
    @SelectKey(statement = "call identity()", keyProperty = "id", before = false, resultType = long.class)
    long create(Unicorn unicorn);

    @Select("SELECT * FROM Unicorns")
    List<Unicorn> findAll();

    @Select("SELECT * FROM Unicorns WHERE id = #{id}")
    Unicorn findOneById(@Param("id") long id);

    @Select("SELECT * FROM Unicorns WHERE age <= #{age} AND gender IS #{gender}")
    List<Unicorn> filterByMaxAgeAndGender(@Param("age") int age, @Param("gender") Gender gender);
}
