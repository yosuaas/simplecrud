package com.yosh.simplecrud.utils;

import com.yosh.simplecrud.data.response.Response;
import com.yosh.simplecrud.data.response.ResponseEmployee;
import org.springframework.http.ResponseEntity;

public class Helpers {
    private Helpers() {
        throw new IllegalStateException("Utility class");
    }

    public static ResponseEntity<Response> createResponse(Response response) {
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    public static ResponseEntity<ResponseEmployee> createResponseEmployee(
            ResponseEmployee responseEmployee) {
        return new ResponseEntity<>(responseEmployee, responseEmployee.getHttpStatus());
    }
}
