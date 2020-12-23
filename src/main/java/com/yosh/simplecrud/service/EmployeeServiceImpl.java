package com.yosh.simplecrud.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.google.common.base.Strings;
import com.yosh.simplecrud.data.input.InputEmployee;
import com.yosh.simplecrud.data.response.Response;
import com.yosh.simplecrud.data.response.ResponseEmployee;
import com.yosh.simplecrud.enumeration.ResponseCollection;
import com.yosh.simplecrud.model.Employee;
import com.yosh.simplecrud.model.specification.EmployeeSpecification;
import com.yosh.simplecrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public Response createEmployee(InputEmployee input) {
        Response response = new Response();
        Optional<Employee> employeeOptional = employeeRepository.findByNik(input.getNik());

        if (employeeOptional.isPresent()) {
            response.setResponse(ResponseCollection.EMPLOYEE_NIK_FOUND);
        } else {
            Employee newEmployee = Employee.createNewEmployee(input.getNik(), input.getName(),
                    input.getAddress(), input.getDob());
            employeeRepository.saveAndFlush(newEmployee);
            response.setResponse(ResponseCollection.SUCCESS);

        }
        return response;
    }

    @Override
    public Response deleteEmployee(String nik) {
        Response response = new Response();
        Optional<Employee> employeeOptional = employeeRepository.findByNik(nik);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employeeRepository.delete(employee);
            response.setResponse(ResponseCollection.SUCCESS);
        } else {
            response.setResponse(ResponseCollection.EMPLOYEE_NOT_FOUND);
        }
        return response;
    }


    @Override
    public ResponseEmployee getEmployee(String nik) {
        ResponseEmployee responseEmployee = new ResponseEmployee();
        Specification<Employee> specification = Specification.where(
                Strings.isNullOrEmpty(nik) ? null : EmployeeSpecification.equals("nik", nik));

        List<Employee> employeeList = employeeRepository.findAll(specification);

        if (employeeList.isEmpty()) {
            responseEmployee.setResponse(ResponseCollection.EMPLOYEE_NOT_FOUND);
        } else {
            responseEmployee.setEmployeeList(employeeList);
            responseEmployee.setResponse(ResponseCollection.SUCCESS);
        }

        return responseEmployee;
    }

    @Override
    @Transactional
    public Response updateEmployee(InputEmployee input) {
        Response response = new Response();
        Optional<Employee> employeeOptional =
                employeeRepository.findById(UUID.fromString(input.getId()));
        if (employeeOptional.isPresent()) {

            Employee employee = employeeOptional.get();
            employee.setNik(input.getNik());
            employee.setName(input.getName());
            employee.setAddress(input.getAddress());
            employee.setDob(input.getDob());
            employee.setLastUpdate(new Date());

            employeeRepository.saveAndFlush(employee);
            response.setResponse(ResponseCollection.SUCCESS);
        } else {
            response.setResponse(ResponseCollection.EMPLOYEE_NOT_FOUND);
        }
        return response;
    }



}
