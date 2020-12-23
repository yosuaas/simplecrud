package com.yosh.simplecrud.data.response;

import java.util.ArrayList;
import java.util.List;
import com.yosh.simplecrud.model.Employee;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ResponseEmployee extends Response {

    List<Employee> employeeList;

    public ResponseEmployee() {
        this.employeeList = new ArrayList<>();
    }
}
