import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    id("java")
}

group = "org.kurt"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
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

val javaDocDir = "build/docs/javadoc"

tasks.javadoc {
    source = sourceSets["main"].allJava + sourceSets["test"].allJava
    classpath = sourceSets["main"].compileClasspath + sourceSets["test"].compileClasspath
    options {
        this as StandardJavadocDocletOptions
        title = "Kurt Teaches Algorithms!"
        encoding = "UTF-8"
        destinationDirectory = file(javaDocDir)
        addBooleanOption("Xdoclint:none", true)  // Suppress all doclint warnings
    }
    doLast {
        // Copy images to the Javadoc resource-files directory
        copy {
            from("src/test/resources/docs")
            into("$javaDocDir/resource-files")
        }
    }
}

