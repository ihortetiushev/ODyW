package ua.nure.odyw.grpc.service;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GreetService {

    @GrpcClient("greet-service")
    private GreetServiceGrpc.GreetServiceBlockingStub serviceStub;

    public String receiveGreeting(String name) {
        GreetRequest request = GreetRequest.newBuilder()
                .setName(name)
                .build();
        return serviceStub.greet(request).getGreeting();
    }
}

