import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.id
import com.google.protobuf.gradle.plugins
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

plugins {
    kotlin("jvm")
    id("com.google.protobuf")
}


repositories {
    mavenCentral()
}
sourceSets {
    main {
        withConvention(KotlinSourceSet::class) {

            kotlin.srcDir("build/generated/source/proto/main/grpc")
            kotlin.srcDir("build/generated/source/proto/main/java")

            java.srcDir("build/generated/source/proto/main/grpc")
            java.srcDir("build/generated/source/proto/main/java")

        }
    }
}

dependencies {
    protobuf(project(":protos"))

    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8")
    implementation("javax.annotation:javax.annotation-api:1.3.2")

    api(Dependencies.protobufUtil)
    api(Dependencies.grpcStub)
    api(Dependencies.grpcProtobuf)
    api(Dependencies.grpcKotlinStub)

    testImplementation("junit:junit:4.12")
}


java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:${Dependencies.Version.protobuf}"
    }

    plugins {

        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:${Dependencies.Version.grpc}"
        }
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:${Dependencies.Version.grpcKotlinStub}"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
                id("grpckt")
            }
        }
    }
}
