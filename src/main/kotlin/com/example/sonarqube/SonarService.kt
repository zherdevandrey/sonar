package com.example.sonarqube

import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping

@Component
class SonarService {
    @GetMapping
    fun getSonar(): String {
        // todo
        var sonar: String? = null

        sonar = ""

        sonar += "sonar"

        return sonar
    }

    @GetMapping
    fun getSonar2(): String {
        // todo
        var sonar: String? = null

        sonar = ""

        sonar += "sonar"

        return sonar
    }
}
