package com.mycodefu;

import com.mongodb.BasicDBObject;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
public class HelloReactiveControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Inject
    MongoClient mongoClient;

    @BeforeEach
    public void setup() {
        MongoCollection<Person> personCollection = mongoClient.getDatabase("people").getCollection("person", Person.class);
        Flux.from(personCollection.deleteMany(new BasicDBObject())).blockFirst(Duration.ofSeconds(5));
        Flux.from(personCollection.insertOne(new Person("Luke"))).blockFirst(Duration.ofSeconds(5));
    }

    @Test
    public void testHello() {
        HttpRequest<String> request = HttpRequest.GET("/hello/reactive/Luke");
        String body = client.toBlocking().retrieve(request);

        assertNotNull(body);
        assertEquals("{\"name\":\"Luke\"}", body);
    }
}