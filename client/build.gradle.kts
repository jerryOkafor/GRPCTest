plugins {
    application
    kotlin("jvm")
}

application.mainClassName = "HelloWorldClientKt"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":stub"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8")

    api(Dependencies.protobufUtil)

    runtimeOnly("io.grpc:grpc-netty:${Dependencies.Version.grpc}")


}