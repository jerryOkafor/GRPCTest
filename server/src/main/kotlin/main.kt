import io.grpc.Server
import io.grpc.ServerBuilder
import io.grpc.stub.StreamObserver
import java.io.IOException

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

class HelloWorldServiceImpl : HelloWorldServiceGrpc.HelloWorldServiceImplBase() {
    override fun hello(
        request: HelloWorld.HelloRequest,
        responseObserver: StreamObserver<HelloWorld.HelloResponse?>
    ) {
        System.out.println(
            "Handling hello endpoint: $request"
        )
        val text: String = request.getText().toString() + " World"
        val response: HelloWorld.HelloResponse = HelloWorld.HelloResponse.newBuilder()
            .setText(text).build()
        responseObserver.onNext(response)
        responseObserver.onCompleted()
    }
}

class HelloWorldServer {
    private var server: Server? = null

    @Throws(IOException::class)
    fun start() {
        server = ServerBuilder.forPort(PORT)
            .addService(HelloWorldServiceImpl())
            .build()
            .start()
    }

    @Throws(InterruptedException::class)
    fun blockUntilShutdown() {
        if (server == null) {
            return
        }
        server?.awaitTermination()
    }

    companion object {
        private const val PORT = 50051
    }
}

fun main() {
    val server = HelloWorldServer()
    server.start()
    server.blockUntilShutdown()
}