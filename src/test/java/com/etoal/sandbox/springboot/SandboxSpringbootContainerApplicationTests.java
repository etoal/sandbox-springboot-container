package com.etoal.sandbox.springboot;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//disabling for now as the config/secret files are created and injected by K8s.  Would need to mimic this in test somehow.
@Disabled
@SpringBootTest
class SandboxSpringbootContainerApplicationTests {

	//disabling for now as the config/secret files are created and injected by K8s.  Would need to mimic this in test somehow.
	@Disabled
	@Test
	void contextLoads() {
	}

}
