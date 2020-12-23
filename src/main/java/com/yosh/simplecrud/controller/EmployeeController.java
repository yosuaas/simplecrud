package com.yosh.simplecrud.controller;

import com.yosh.simplecrud.data.input.InputEmployee;
import com.yosh.simplecrud.data.response.Response;
import com.yosh.simplecrud.data.response.ResponseEmployee;
import com.yosh.simplecrud.service.EmployeeService;
import com.yosh.simplecrud.utils.Helpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<ResponseEmployee> getEmployee(
            @RequestParam(required = false, defaultValue = "") String nik) {
        return Helpers.createResponseEmployee(employeeService.getEmployee(nik));
    }

    @PutMapping("/employee")
    public ResponseEntity<Response> updateEmployee(@RequestBody InputEmployee input) {
        return Helpers.createResponse(employeeService.updateEmployee(input));
    }

    @PostMapping("/employee")
    public ResponseEntity<Response> newAccount(@RequestBody InputEmployee input) {
        return Helpers.createResponse(employeeService.createEmployee(input));
    }

    @DeleteMapping("/employee")
    public ResponseEntity<Response> deleteaccount(@RequestBody InputEmployee input) {
        return Helpers.createResponse(employeeService.deleteEmployee(input.getNik()));
    }
}
