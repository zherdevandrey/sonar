package com.example.sonarqube

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SonarqubeApplication

fun main(args: Array<String>) {
    runApplication<SonarqubeApplication>(*args)
}
