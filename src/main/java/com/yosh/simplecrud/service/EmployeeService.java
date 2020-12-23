package com.yosh.simplecrud.service;

import com.yosh.simplecrud.data.input.InputEmployee;
import com.yosh.simplecrud.data.response.Response;
import com.yosh.simplecrud.data.response.ResponseEmployee;

public interface EmployeeService {

    Response createEmployee(InputEmployee input);

    Response deleteEmployee(String nik);

    Response updateEmployee(InputEmployee input);

    ResponseEmployee getEmployee(String nik);

}
