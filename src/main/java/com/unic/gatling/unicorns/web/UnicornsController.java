package com.unic.gatling.unicorns.web;

import com.unic.gatling.unicorns.mappers.Gender;
import com.unic.gatling.unicorns.mappers.Unicorn;
import com.unic.gatling.unicorns.mappers.UnicornMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(path = "/unicorns")
public class UnicornsController {

    private final UnicornMapper unicornMapper;

    @Autowired
    public UnicornsController(UnicornMapper unicornMapper) {
        this.unicornMapper = unicornMapper;
    }

    @RequestMapping(method = POST)
    @ResponseStatus(CREATED)
    public Unicorn create(@RequestBody Unicorn unicorn) {

        unicorn.id = unicornMapper.create(unicorn);
        return unicorn;
    }

    @RequestMapping(method = GET)
    public List<Unicorn> findAll() {

        return unicornMapper.findAll();
    }

    @RequestMapping(path = "/{id}", method = GET)
    public Unicorn get(@PathVariable("id") long id) {

        return unicornMapper.findOneById(id);
    }

    @RequestMapping(method = GET)
    public List<Unicorn> filterByMaxAgeAndGender(@RequestParam int age, @RequestParam Gender gender) {

        return unicornMapper.filterByMaxAgeAndGender(age, gender);
    }
}
