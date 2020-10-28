import com.google.protobuf.gradle.protobuf

plugins {
    application
    kotlin("jvm")
}

application.mainClassName = "HelloWorldServerKt"

repositories {
    mavenCentral()
}


dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":stub"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8")

    runtimeOnly("io.grpc:grpc-netty:${Dependencies.Version.grpc}")
}

