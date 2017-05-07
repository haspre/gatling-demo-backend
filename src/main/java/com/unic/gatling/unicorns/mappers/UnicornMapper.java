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
    @SelectKey(statement = "CALL IDENTITY()", keyProperty = "id", before = false, resultType = long.class)
    void create(Unicorn unicorn);

    @Select("SELECT * FROM Unicorns WHERE id = #{id}")
    Unicorn findOneById(@Param("id") long id);

    @Select("<script>" +
            "   SELECT * FROM Unicorns " +
            "   <where>" +
            "       <if test=\"age != null\">age=#{age}</if>" +
            "       <if test=\"gender != null\">AND gender=#{gender}</if>" +
            "   </where>" +
            "</script>")
    List<Unicorn> filter(@Param("age") Integer age, @Param("gender") Gender gender);
}
