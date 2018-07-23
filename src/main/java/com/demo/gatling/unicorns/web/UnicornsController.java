package com.demo.gatling.unicorns.web;

import com.demo.gatling.unicorns.mappers.Gender;
import com.demo.gatling.unicorns.mappers.Unicorn;
import com.demo.gatling.unicorns.mappers.UnicornMapper;

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

        unicornMapper.create(unicorn);
        return unicorn;
    }

    @RequestMapping(path = "/{id}", method = GET)
    public Unicorn get(@PathVariable("id") long id) {

        return unicornMapper.findOneById(id);
    }

    @RequestMapping(method = GET)
    public List<Unicorn> filter(@RequestParam(required = false) Integer maxAge, @RequestParam(required = false) Gender gender,
                                @RequestParam(required = false, defaultValue = "500") int maxResults) {

        return unicornMapper.filter(maxAge, gender, maxResults);
    }
}
