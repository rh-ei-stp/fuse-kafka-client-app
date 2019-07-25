package org.redhat.mdcr.kafka.config;

import org.apache.camel.component.kafka.KafkaComponent;
import org.apache.camel.component.kafka.KafkaConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaComponentConfig {
	
	@Value("${prod.kafkaBootStrapURL}")
	private String prodKafkaBootStapURL;
	
	@Value("${dr.kafkaBootStrapURL}")
	private String drKafkaBootStapURL;
	
	@Autowired
	ApplicationProperties props;
	
	//Define two different beans for producer and consumer so that producer and consumer specific configuration can be injected 
	//accordingly
    @Bean(name="prodKafkaProducer")
    public KafkaComponent prodKafkaProducerComponent(){
        KafkaComponent kafka = new KafkaComponent();
        kafka.setConfiguration(getProducerKafkaConfiguration());
        kafka.setBrokers(prodKafkaBootStapURL);
        return kafka;
    }
    
    @Bean(name="prodKafkaConsumer")
    public KafkaComponent prodKafkaConsumerComponent(){
        KafkaComponent kafka = new KafkaComponent();
        kafka.setConfiguration(getConsumerKafkaConfiguration());
        kafka.setBrokers(prodKafkaBootStapURL);
        return kafka;
    }
    
    @Bean(name="drKafkaProducer")
    public KafkaComponent drKafkaProducerComponent(){
        KafkaComponent kafka = new KafkaComponent();
        kafka.setConfiguration(getProducerKafkaConfiguration());
        kafka.setBrokers(drKafkaBootStapURL);
        return kafka;
    }
    
    @Bean(name="drKafkaConsumer")
    public KafkaComponent drKafkaConsumerComponent(){
        KafkaComponent kafka = new KafkaComponent();
        kafka.setConfiguration(getConsumerKafkaConfiguration());
        kafka.setBrokers(drKafkaBootStapURL);
        return kafka;
    }
    private KafkaConfiguration getCommonKafkaConfiguration() {

    	KafkaConfiguration config = new KafkaConfiguration();
    	config.setSecurityProtocol("SASL_SSL");
    	config.setSslTruststoreLocation(props.getSslTruststoreLocation());
    	config.setSslTruststorePassword(props.getSslTruststorePassword());
    	config.setSslEndpointAlgorithm(props.getSslEndpointAlgorithm());
    	config.setSaslMechanism(props.getSaslMechanism());
    	config.setSaslJaasConfig("org.apache.kafka.common.security.scram.ScramLoginModule required username=\""
    			+ props.getSaslUsername() + "\" password=\"" + props.getSaslPassword() + "\";");

    	return config;
    }
    
    private KafkaConfiguration getConsumerKafkaConfiguration() {

    	KafkaConfiguration config = getCommonKafkaConfiguration();
    	/* Set any consumer specific configuration */

    	return config;
    }
    
    private KafkaConfiguration getProducerKafkaConfiguration() {
    	KafkaConfiguration config = getCommonKafkaConfiguration();
    	/* Set any producer specific configuration */

    	return config;
    }
}
