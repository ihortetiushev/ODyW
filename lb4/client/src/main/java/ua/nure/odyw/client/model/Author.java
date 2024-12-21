package ua.nure.odyw.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Author(String id, String firstName, String lastName) {
}