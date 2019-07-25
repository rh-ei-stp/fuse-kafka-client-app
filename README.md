# Multi-Datacenter Reference Architecture :: Fuse Kafka Client Application
A Spring Boot application written with Red Hat Fuse components that acts as a producer/consumer to/from kafka topic

## Instructions to run the springboot application

1. Clone this repository to your local computer

1. Modify the route URLs, kafka user credentials etc. in  src/main/resources/application.properties accordingly

1. Build the application: `mvn clean install`

1. Kafka fuse client can be run in different ways i.e. it can be run to produce and consume messages OR produce only OR consume only to datacenter-a kafka cluster by passing different system properties. Similarly, it can be done for datacenter-b kafka cluster as well.
	1. Produce messages to `prod.kafkaBootStrapURL`. `java -jar -DprodProducer=true target/fuse-kafka-client-app-1.0-SNAPSHOT.jar`
    1. Consume messages from `prod.kafkaBootStrapURL`. `java -jar -DprodConsumer=true target/fuse-kafka-client-app-1.0-SNAPSHOT.jar`
    1. Produce and Consume messages to/from `prod.kafkaBootStrapURL`. `java -jar -DprodProducer=true -DprodConsumer=true target/fuse-kafka-client-app-1.0-SNAPSHOT.jar`
    1. Produce and Consume messages to/from `dr.kafkaBootStrapURL`. `java -jar -DdrProducer=true -DdrConsumer=true target/fuse-kafka-client-app-1.0-SNAPSHOT.jar