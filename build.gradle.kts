import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    id("java")
    id("ru.vyarus.mkdocs") version "4.0.1"
    id("ru.vyarus.quality") version "5.0.0"
}

group = "org.kurt"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.0-M2")
    // https://mvnrepository.com/artifact/org.ow2.asm/asm
    testImplementation("org.ow2.asm:asm:9.7")
    // https://mvnrepository.com/artifact/org.mockito/mockito-core
    testImplementation("org.mockito:mockito-core:5.12.0")
//    // https://mvnrepository.com/artifact/org.mockito/mockito-junit-jupiter
//    testImplementation("org.mockito:mockito-junit-jupiter:5.12.0")

}

tasks.test {
    useJUnitPlatform()
    jvmArgs = listOf("-Xms512m", "-Xmx1024m")
    testLogging {
        events("passed", "skipped", "failed") // Specify which events to log
        showStandardStreams = true // Show standard output and error streams
        exceptionFormat = TestExceptionFormat.FULL  // Show full exception stack traces
    }
}

quality {
    /**
     * spotbugs is chill
     */
    spotbugs = true
    checkstyle = false
    /**
     * Strict quality leads to build fail on any violation found. If disabled, all violation
     * are just printed to console.
     */
    strict = false
}

python{
    requirements {
        useVenv = true
        use = true
        file = "src/doc/requirements.txt"
    }
}

