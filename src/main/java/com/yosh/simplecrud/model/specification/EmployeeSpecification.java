package com.yosh.simplecrud.model.specification;

import com.yosh.simplecrud.model.Employee;
import org.springframework.data.jpa.domain.Specification;

public final class EmployeeSpecification {

    private EmployeeSpecification() {
        throw new IllegalStateException("Specification class");
    }

    public static Specification<Employee> equals(String expression, String expression2) {
        return (root, query, builder) -> builder.equal(root.get(expression), expression2);
    }
}
