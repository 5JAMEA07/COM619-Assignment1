package com.group.devops;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(locations = "classpath:persistence-test.properties")
@SpringBootTest
class DevOpsApplicationTests {

	@Test
	void contextLoads() {
	}

}
