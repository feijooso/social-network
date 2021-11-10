import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.31")
    testImplementation("org.assertj:assertj-core:3.11.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
    testImplementation("net.bytebuddy:byte-buddy:1.11.22") // Added for mockk compatibility with JDK16
    testImplementation("io.mockk:mockk:1.12.0")
}

tasks.withType<KotlinCompile> { kotlinOptions.jvmTarget = "16" }

tasks.withType<Test> {
    useJUnitPlatform()
}