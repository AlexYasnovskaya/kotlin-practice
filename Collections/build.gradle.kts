plugins {
    kotlin("jvm") version "2.2.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("junit:junit:4.12")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(24)
}