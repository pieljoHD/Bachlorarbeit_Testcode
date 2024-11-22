plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("org.testng:testng:7.10.2")
    implementation ("org.uncommons:reportng:1.1.4")
    implementation ("io.qameta.allure:allure-testng:2.27.0")
    implementation ("org.seleniumhq.selenium:selenium-java:4.23.0")
    implementation ("io.appium:java-client:9.2.3")
    implementation ("org.apache.logging.log4j:log4j-core:2.23.1")
}

tasks.test {
    useJUnitPlatform()
}