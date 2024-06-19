package com.java.ems_backned.service.impl;

import com.java.ems_backned.dto.dto.EmployeeDto;
import com.java.ems_backned.entity.Employee;
import com.java.ems_backned.mapper.EmployeeMapper;
import com.java.ems_backned.repository.EmployeeRepository;
import com.java.ems_backned.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee saveEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(saveEmployee);
    }

}
