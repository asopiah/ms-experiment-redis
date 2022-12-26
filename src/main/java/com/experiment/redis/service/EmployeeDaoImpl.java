package com.experiment.redis.service;

import com.experiment.redis.data.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author asopia
 */
@Service
public class EmployeeDaoImpl implements IEmployeeDao {

    private static final String MAPPING_KEY = "EMPLOYEES_REG_TEMP_RECORDS";

    private final ObjectMapper objectMapper;
    private final StringRedisTemplate stringRedisTemplate;
    @Resource(name = "stringRedisTemplate")  // 'redisTemplate' is defined as a Bean in AppConfig.java
    private HashOperations<String, String, String> hashOperations;

    public EmployeeDaoImpl(ObjectMapper objectMapper, StringRedisTemplate stringRedisTemplate) {
        this.objectMapper = objectMapper;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void saveEmployee(Employee emp) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(emp);
        hashOperations.putIfAbsent(MAPPING_KEY, emp.getRequestRefId(), json);
        stringRedisTemplate.expire(MAPPING_KEY, 15, TimeUnit.SECONDS); // Set TTL for the MAPPING_KEY

    }


    @Override
    public void saveAllEmployees(Map<Integer, Employee> map) {
        map.forEach((integer, employee) -> {
            try {
                saveEmployee(employee);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public Employee getOneEmployee(String requestRefId) throws JsonProcessingException {
        String employeeString = hashOperations.get(MAPPING_KEY, requestRefId);
        return objectMapper.readValue(employeeString, Employee.class);
    }

    @Override
    public void updateEmployee(Employee emp) throws JsonProcessingException {
        hashOperations.put(MAPPING_KEY, emp.getRequestRefId(), objectMapper.writeValueAsString(emp));
    }

    @Override
    public Map<String, String> getAllEmployees() {
        return hashOperations.entries(MAPPING_KEY);
    }

    @Override
    public void deleteEmployee(String id) {
        hashOperations.delete(MAPPING_KEY, id);
    }
}
