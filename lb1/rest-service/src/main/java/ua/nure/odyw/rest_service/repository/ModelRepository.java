package ua.nure.odyw.rest_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.odyw.rest_service.model.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
