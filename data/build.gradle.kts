plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    // Modules
    implementation(project(":entity"))

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

    // Arrow
    implementation("io.arrow-kt:arrow-core:1.2.1")

    // Java Inject
    implementation("javax.inject:javax.inject:1")
}
