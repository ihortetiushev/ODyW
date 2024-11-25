package ua.nure.odyw.rest_client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ua.nure.odyw.rest_client.model.Model;

import java.util.Optional;

@FeignClient(name = "modelService", url = "http://localhost:8080")
public interface ModelService {

    @RequestMapping(method = RequestMethod.GET, value = "/model")
    Optional<Model> getModel(@RequestParam Long id);

    @PostMapping(value = "/model")
    Model createModel(@RequestBody Model model);

    @PutMapping(value = "/model")
    Model updateModel(@RequestBody Model model);

    @DeleteMapping(value = "/model")
    void deleteModel(@RequestParam Long id);
}
