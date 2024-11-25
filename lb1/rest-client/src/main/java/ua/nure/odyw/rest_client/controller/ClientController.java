package ua.nure.odyw.rest_client.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.nure.odyw.rest_client.model.Model;
import ua.nure.odyw.rest_client.service.ModelService;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ModelService service;

    @PostMapping(value = "/model")
    ResponseEntity<Model> createModel(@RequestBody @Validated Model model) {
        return new ResponseEntity(service.createModel(model), HttpStatus.CREATED);
    }

    @GetMapping(value = "/model")
    ResponseEntity<Model> getModel(@RequestParam Long id) {
        Optional<Model> byId = service.getModel(id);
        return byId.map(ResponseEntity::ok).orElse(notFound().build());
    }

    @PutMapping(value = "/model")
    ResponseEntity<Model> updateModel(@RequestBody @Validated Model model) {
        return ResponseEntity.ok(service.updateModel(model));
    }

    @DeleteMapping(value = "/model")
    ResponseEntity<Model> deleteModel(@RequestParam Long id) {
        service.deleteModel(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
