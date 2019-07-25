package org.redhat.mdcr.kafka.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProducerRouteBuilder extends RouteBuilder {
	
	@Value("${prodProducer:false}")
	private boolean prodProducerRoute;
	
	@Value("${drProducer:false}")
	private boolean drProducerRoute;
	
	@Override
	public void configure() throws Exception {
		
		from("timer://foo?fixedRate=true&period=1000").routeId("prodProducer").autoStartup(prodProducerRoute)
			.setBody(simple("Production -> Test Message at ->" + "${date:now}")).log("${body}")
			.to("prodKafkaProducer:my-topic?clientId=prodCamelJavaDSLKafka")
			;
		
		from("timer://foo?fixedRate=true&period=1000").routeId("drProducer").autoStartup(drProducerRoute)
			.setBody(simple("DR -> Test Message at ->" + "${date:now}")).log("${body}")
			.to("drKafkaProducer:my-topic?clientId=drCamelJavaDSLKafka")
		;
	}

}
