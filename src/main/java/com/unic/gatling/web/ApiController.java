package com.unic.gatling.web;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.Math.abs;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ApiController {

    private final Map<Long, Resource> resources = new ConcurrentHashMap<>();
    private final Random random = new Random();

    @RequestMapping(path = "/resources", method = POST)
    @ResponseStatus(code = CREATED)
    public Resource create() {
        final Resource resource = new Resource(abs(random.nextLong()));
        resources.put(resource.id, resource);
        return resource;
    }

    @RequestMapping(path = "/resources/{id}", method = GET)
    public Resource get(@PathVariable("id") Long id) {
        return resources.get(id);
    }
}
