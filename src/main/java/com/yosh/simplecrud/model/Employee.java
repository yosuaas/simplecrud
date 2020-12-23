package com.yosh.simplecrud.model;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.yosh.simplecrud.constant.TableNames;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = TableNames.MASTER_EMPLOYEE)
public class Employee {

    @Id
    @Column(name = "\"ID\"")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "\"NIK\"")
    private String nik;

    @Column(name = "\"NAME\"")
    private String name;

    @Column(name = "\"ADDRESS\"")
    private String address;

    @Column(name = "\"DOB\"")
    private Date dob;

    @Column(name = "\"CREATED_DATE\"")
    private Date createdDate;

    @Column(name = "\"LAST_UPDATE\"")
    private Date lastUpdate;

    public static Employee createNewEmployee(String nik, String name, String address, Date dob) {
        Employee employee = new Employee();
        employee.setNik(nik);
        employee.setName(name);
        employee.setAddress(address);
        employee.setDob(dob);
        employee.setCreatedDate(new Date());
        employee.setLastUpdate(new Date());

        return employee;
    }
}
