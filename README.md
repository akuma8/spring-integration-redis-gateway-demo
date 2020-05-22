# Project organisation

Prerequisite: JDK11, Maven, a Redis server running on its default port.

The goal of this simple Spring Boot project is to show how `RedisQueueOutboundGateway` and `RedisQueueInboundGateway` are used in a request/reply context.

The project contains 3 modules(common, servicea, serviceb):

- **common**: contains common components and dependencies shared by the other 2 modules. There are defined endpoint(@MessagingGateway) used by *servicea*, a `DirectChannel` and the `RedisQueueOutboundGateway`.
It also defines a simple data model for message exchanging(`com.example.events.OnInfosProfileEvent.java``) 

- **servicea**: runs on port 9080 and expose an HTTP endpoint(`GET http://localhost:9080/infos/{username}`). Sending a request to that url triggers the messaging flow between *servicea* and *serviceb* via Redis.

- **serviceb**: runs on port 9081, its purpose is to receive a message from `servicea` via Redis and reply back. 

Import the project in your IDE and run `mvn clean install` in the **common** module first then do the same in other applications.
