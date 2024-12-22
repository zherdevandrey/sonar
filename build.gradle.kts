plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.spring") version "1.9.23"
    id("org.springframework.boot") version "3.4.1"
    id("io.spring.dependency-management") version "1.1.7"

    id("org.sonarqube") version "4.3.0.3225"
    id("io.gitlab.arturbosch.detekt") version "1.23.6"

    id("org.jlleitschuh.gradle.ktlint") version "12.1.1" // Замените на актуальную версию плагина Ktlint
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

sonarqube {
    properties {
        property("sonar.projectKey", "sonarqube-example")
        property("sonar.host.url", "http://localhost:9000")
        property("sonar.login", "sqa_d201df11801e2f8ed3b38e34443b91f64f53510b") // Замените на ваш токен

        property("sonar.issuesReport.console.enable", "true")

        property("sonar.language", "kotlin")
    }
}

detekt {
    toolVersion = "1.23.6"
//    config = files("detekt-config.yml") // Optional: your custom Detekt configuration
//    reports {
//        xml.required.set(true) // Generate XML report for SonarQube
//        html.required.set(true) // HTML report for local inspection
//    }

    buildUponDefaultConfig = false
    allRules = true
    ignoreFailures = false
}

// Конфигурация плагина Ktlint
ktlint {
    version.set("1.0.0") // Укажите версию Ktlint
    debug.set(false) // Включение/выключение режима отладки
    android.set(false) // Если проект использует Android
    outputToConsole.set(true) // Вывод ошибок в консоль
    outputColorName.set("RED") // Цвет вывода в консоли
    ignoreFailures.set(false) // Продолжать сборку, даже если есть ошибки
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.SARIF)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
    }
    filter {
        exclude("**/generated/**") // Исключить файлы из проверки
        include("**/kotlin/**") // Включить только файлы Kotlin
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
