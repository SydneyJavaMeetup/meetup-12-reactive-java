# Sydney Java Meet-Up #12
## Reactive Programming in Java!
https://www.meetup.com/sydney-java/events/290471569/

### Program
6pm - Networking/Drinks/Food  
6:30pm - Event Intro and Job Shouts  
6:35pm - Reactive Coding in Java  
Presenting reactive programming as a paradigm using Java and going through the advantages, use cases and example implementation.
by Dana Dabbagh + Reynaldo Rojas, Technical Leads @ Lexicon  
7:05pm - 25 minute break  
7:30pm - Intro to the Reactive MongoDB Java Driver  
A quick tour of what you can do with MongoDB's reactive driver. Building a microservice with JAX-RS async and reactive Mongo.  
8pm Event Finish

### Intro
Program

Quick acknowledgement of:
* MongoDB for hosting us!

Ethos, vibe
* openness
* inclusiveness
* learning
* no experts, we're a community of peers rather than a mixture of experts and novices
* supportiveness, we're here for each other

### Job Shouts
“Before we get into the tech talks, are there any job shoutouts?”


# Talks

## Reactive Coding in Java
Over to Dana and Reynaldo!

## Intro to the Reactive Java Driver for MongoDB
Why use Reactive to access a database? 

### Creating Hello World Java 19

IntelliJ -> New Project
- Java 19
- Maven
- Group ID and Artifact ID

##### Basic POM - Always Add Unit Tests!
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.mycodefu</groupId>
  <artifactId>mongo-reactive</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>jar</packaging>

  <name>mongo-reactive</name>
  <url>http://maven.apache.org</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>19</maven.compiler.source>
    <maven.compiler.target>19</maven.compiler.target>
  </properties>

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.13.2</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>
```


##### Driver
https://www.mongodb.com/docs/drivers/reactive-streams/  
https://github.com/mongodb/mongo-java-driver/tree/master/driver-reactive-streams  

Add Mongo Driver:
```
<dependency>
  <groupId>org.mongodb</groupId>
  <artifactId>mongodb-driver-reactivestreams</artifactId>
  <version>4.8.0</version>
</dependency>
```

Note: Comes with Project Reactor - use the awesome APIs to abstract away the cumbersome Publisher/Subscriber interfaces. 
