package ua.nure.odyw.rest_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.nure.odyw.rest_service.model.Model;
import ua.nure.odyw.rest_service.repository.ModelRepository;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final ModelRepository repository;

    @PostMapping(value = "/model")
    ResponseEntity<Model> createModel(@RequestBody @Validated Model model) {
        return new ResponseEntity(repository.save(model), HttpStatus.CREATED);
    }

    @GetMapping(value = "/model")
    ResponseEntity<Model> getModel(@RequestParam Long id) {
        Optional<Model> byId = repository.findById(id);
        return byId.map(ResponseEntity::ok).orElse(notFound().build());
    }

    @PutMapping(value = "/model")
    ResponseEntity<Model> updateModel(@RequestBody @Validated Model model) {
        Optional<Model> byId = repository.findById(model.getId());
        if (byId.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(repository.save(model));
    }

    @DeleteMapping(value = "/model")
    ResponseEntity<Model> deleteModel(@RequestParam Long id) {
        Optional<Model> byId = repository.findById(id);
        if (!byId.isEmpty()) {
            repository.delete(byId.get());
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
