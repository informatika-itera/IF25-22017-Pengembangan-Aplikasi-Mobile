plugins {
    kotlin("jvm") version "1.9.24" apply false
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
    }

    dependencies {
        "testImplementation"(kotlin("test"))
        "testImplementation"("org.junit.jupiter:junit-jupiter:5.10.2")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
