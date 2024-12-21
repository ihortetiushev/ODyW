package ua.nure.odyw.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Book(String id, String name, Integer pageCount, Author author) {
}
