package org.redhat.mdcr.kafka.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties
@Component
public class ApplicationProperties {
	
	private String sslTruststoreLocation;
	private String sslTruststorePassword;
	private String sslEndpointAlgorithm;
	private String saslMechanism;
	private String saslUsername;
	private String saslPassword;

	public String getSslTruststoreLocation() {
		return sslTruststoreLocation;
	}

	public void setSslTruststoreLocation(String sslTruststoreLocation) {
		this.sslTruststoreLocation = sslTruststoreLocation;
	}

	public String getSslTruststorePassword() {
		return sslTruststorePassword;
	}

	public void setSslTruststorePassword(String sslTruststorePassword) {
		this.sslTruststorePassword = sslTruststorePassword;
	}

	public String getSslEndpointAlgorithm() {
		return sslEndpointAlgorithm;
	}

	public void setSslEndpointAlgorithm(String sslEndpointAlgorithm) {
		this.sslEndpointAlgorithm = sslEndpointAlgorithm;
	}

	public String getSaslMechanism() {
		return saslMechanism;
	}

	public void setSaslMechanism(String saslMechanism) {
		this.saslMechanism = saslMechanism;
	}

	public String getSaslUsername() {
		return saslUsername;
	}

	public void setSaslUsername(String saslUsername) {
		this.saslUsername = saslUsername;
	}

	public String getSaslPassword() {
		return saslPassword;
	}

	public void setSaslPassword(String saslPassword) {
		this.saslPassword = saslPassword;
	}
}
