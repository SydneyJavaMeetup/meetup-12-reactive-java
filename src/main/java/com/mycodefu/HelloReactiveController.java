package com.mycodefu;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller("/hello/reactive")
public class HelloReactiveController {

    @Get("/{name}")
    public Mono<Person> greet(String name) {
        return Mono.just(new Person(name));
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public Flux<Person> findAll() {
        return Flux.just(new Person("John"), new Person("Jane"));
    }

}
