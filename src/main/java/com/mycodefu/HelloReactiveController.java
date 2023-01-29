package com.mycodefu;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.mongodb.client.model.Filters.eq;

@Controller("/hello/reactive")
public class HelloReactiveController {

    @Inject
    MongoClient mongoClient;

    @Get("/{name}")
    public Mono<Person> greet(String name) {
        return Mono
                .from(getPersonMongoCollection().find(eq("name", name)).first());
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public Flux<Person> findAll() {
        return Flux.from(getPersonMongoCollection().find());
    }

    private MongoCollection<Person> getPersonMongoCollection() {
        return mongoClient.getDatabase("people").getCollection("person", Person.class);
    }
}
