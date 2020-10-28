/*
 * GRPCTest
 *
 * Copyright (C) 2020 Jerry Okafor
 * https://jerryokafor.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

object Dependencies {
    object Version {
        const val kotlin = "1.4.10"
        const val ktor = "1.4.1"
        const val logback = "1.2.1"
        const val exposed = "0.18.1"
        const val hikaricp = "3.3.1"
        const val postgres = "42.2.4.jre7"
        const val grpc = "1.32.1"
        const val grpcKotlinStub = "0.1.5"
        const val protobuf = "3.13.0"
    }

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Version.kotlin}"

    const val protobufUtil = "com.google.protobuf:protobuf-java-util:${Version.protobuf}"
    const val grpcStub = "io.grpc:grpc-stub:${Version.grpc}"
    const val grpcProtobuf = "io.grpc:grpc-protobuf:${Version.grpc}"
    const val grpcKotlinStub = "io.grpc:grpc-kotlin-stub:${Version.grpcKotlinStub}"

    const val ktorServer = "io.ktor:ktor-server-netty:${Version.ktor}"
    const val ktorServerCore = "io.ktor:ktor-server-core:${Version.ktor}"
    const val ktorLocations = "io.ktor:ktor-locations:${Version.ktor}"
    const val ktorSessions = "io.ktor:ktor-server-sessions:${Version.ktor}"
    const val ktorAuth = "io.ktor:ktor-auth:${Version.ktor}"
    const val ktorAuthJwt = "io.ktor:ktor-auth-jwt:${Version.ktor}"
    const val ktorGson = "io.ktor:ktor-gson:${Version.ktor}"
    const val ktorLogback = "ch.qos.logback:logback-classic:${Version.logback}"

    const val ktorServerTest = "io.ktor:ktor-server-tests:${Version.ktor}"

    val exposedCore = "org.jetbrains.exposed:exposed-core:${Version.exposed}"
    val exposedDao = "org.jetbrains.exposed:exposed-dao:${Version.exposed}"
    val exposedJDBC = "org.jetbrains.exposed:exposed-jdbc:${Version.exposed}"
    val postgres = "org.postgresql:postgresql:${Version.postgres}"
    val hijariCP = "com.zaxxer:HikariCP:${Version.hikaricp}"
}