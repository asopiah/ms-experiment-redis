package com.experiment.redis.service;

import com.experiment.redis.data.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

/**
 * @author asopia
 */
public interface IEmployeeDao {
    void saveEmployee(Employee emp) throws JsonProcessingException;

    //Employee getOneEmployee(Integer id) throws JsonProcessingException;

    Employee getOneEmployee(String requestRefId) throws JsonProcessingException;

    //Employee getOneEmployee(Integer id);
    void updateEmployee(Employee emp) throws JsonProcessingException;
    Map<String, String> getAllEmployees();
    void deleteEmployee(String id);
    void saveAllEmployees(Map<Integer, Employee> map);
}
