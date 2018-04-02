package com.surpreso.spring_mongo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    private class JsonResponse {
        String error;

        public JsonResponse() {
        }

        public JsonResponse(String message) {
            super();
            this.error = message;
        }

        public String getError() {
            return error;
        }

        public void setMessage(String message) {
            this.error = message;
        }
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<JsonResponse> handleException(Exception e) {
        JsonResponse response = new JsonResponse();
        response.setMessage("Invalid input. Value should be numbers only. Divisor should not be zero.");
        return new ResponseEntity<JsonResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<JsonResponse> RuntimeExceptionHandler(RuntimeException e) {
        JsonResponse response = new JsonResponse();
        response.setMessage("Something goes wrong. Please, contact support.");
        return new ResponseEntity<JsonResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}