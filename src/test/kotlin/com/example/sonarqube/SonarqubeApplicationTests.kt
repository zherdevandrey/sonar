package com.example.sonarqube

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SonarqubeApplicationTests {
    @Test
    fun contextLoads() {
        Assertions.assertEquals(1, 1)
    }
}
