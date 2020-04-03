package org.redhat.mdcr.kafka.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConsumerRouteBuilder extends RouteBuilder {
	
	@Value("${prodConsumer:false}")
	private boolean prodConsumerRoute;
	
	@Value("${drConsumer:false}")
	private boolean drConsumerRoute;
	
	
	@Override
	public void configure() throws Exception {
    	
    	from("prodKafkaConsumer:my-topic?clientId=prodCamelJavaDSLKafkaConsumer&groupId=camelJavaDSLConsumerGroup")
    		.autoStartup(prodConsumerRoute)
    		.routeId("prodConsumer")
    		.log("Production Consumer-> ${body}")
			;
    	
    	from("drKafkaConsumer:my-topic?clientId=drCamelJavaDSLKafkaConsumer&groupId=camelJavaDSLConsumerGroup")
    		.autoStartup(drConsumerRoute)
    		.routeId("drConsumer")
			.log("DR Consumer-> ${body}")
			;
	}

}
