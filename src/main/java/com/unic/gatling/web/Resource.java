package com.unic.gatling.web;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

class Resource {

    @JsonSerialize(using=ToStringSerializer.class)
    final long id;

    Resource(long id) {
        this.id = id;
    }
}
