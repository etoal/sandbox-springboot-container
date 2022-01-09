package com.etoal.sandbox.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//this property file is being injected by a configmap from Kubernetes
@PropertySource("file:/etc/config/application.properties")
public class ApplicationProperties {

}
