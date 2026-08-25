package com.fooddelivery.eureka;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {"spring.cloud.config.enabled=false"})
class EurekaServerApplicationStartupTest {
@Test
    void contextLoads() {
        // Just tests if context boots correctly
    }
}
