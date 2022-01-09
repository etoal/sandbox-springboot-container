package com.etoal.sandbox.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//This property file is being injected by a Secret from Kubernetes
@PropertySource("file:/etc/secret/secrets.properties")
public class SecretConfiguration {

}
