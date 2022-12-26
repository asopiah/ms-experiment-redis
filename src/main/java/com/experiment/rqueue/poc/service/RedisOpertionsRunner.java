package com.experiment.rqueue.poc.service;

import com.experiment.rqueue.poc.data.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

/**
 * @author asopia
 */
@Component
public class RedisOpertionsRunner implements CommandLineRunner {
    @Autowired
    private IEmployeeDao empDao;

    @Override
    public void run(String... args) throws Exception {

        //saving one employee
        //empDao.saveEmployee(new Employee(500, "Emp0", 2150.0));
        //saving multiple employees
        System.out.println("Now Saving multiple employees");
        empDao.saveAllEmployees(
                Map.of(501, new Employee(UUID.randomUUID().toString(), "Transaction Successful", "Success"),
                       502, new Employee(UUID.randomUUID().toString(), "Transaction failed!", "Failed"),
                       503, new Employee(UUID.randomUUID().toString(), "Transaction Successful", "Success")
                )
        );

        //modifying employee with empId 503
        System.out.println("Now Modifying employee with empId 503");
        empDao.updateEmployee(new Employee(UUID.randomUUID().toString(), "Updated test", "Updated test"));

        //deleting employee with empID 500
        System.out.println("Now Deleting employee with empID 500");
        empDao.deleteEmployee("0620ad64-e151-4a20-9aca-f8a186dd0fc7");

        //retrieving all employees
        System.out.println("Now retrieving all employees");
        empDao.getAllEmployees().forEach((k,v)-> System.out.println(k +" : "+v));

        //retrieving employee with empID 501
        //System.out.println("Emp details for 501 : "+empDao.getOneEmployee("bf02ebae-717b-4aa3-9ae2-d0fbd0a04864"));
       // System.out.println("Transaction Details : "+empDao.getOneEmployee("0028ee72-2bef-4e08-9a8d-11b387250test"));
    }
}
