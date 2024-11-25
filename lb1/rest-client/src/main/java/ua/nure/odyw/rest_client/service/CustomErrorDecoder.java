package ua.nure.odyw.rest_client.service;

import feign.Response;
import feign.codec.ErrorDecoder;
import ua.nure.odyw.rest_client.exception.BadRequestException;
import ua.nure.odyw.rest_client.exception.InternalServerErrorException;
import ua.nure.odyw.rest_client.exception.NotFoundException;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                // Handle 400 Bad Request
                return new BadRequestException("Bad Request");
            case 404:
                return new NotFoundException("Not Found");
            case 500:
                // Handle 500 Internal Server Error
                return new InternalServerErrorException("Internal Server Error");
            default:
                return new Exception("Generic error");
        }
    }
}
