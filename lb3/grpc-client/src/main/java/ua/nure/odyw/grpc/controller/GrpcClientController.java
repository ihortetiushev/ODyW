package ua.nure.odyw.grpc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.odyw.grpc.model.Model;
import ua.nure.odyw.grpc.service.GreetService;

@RestController
@RequiredArgsConstructor
public class GrpcClientController {

    private final GreetService greetService;

    @GetMapping("/greeting")
    ResponseEntity<Model> getModel(@RequestParam String name) {
        Model model = new Model();
        model.setMessage(greetService.receiveGreeting(name));
        return ResponseEntity.ok(model);
    }

}
