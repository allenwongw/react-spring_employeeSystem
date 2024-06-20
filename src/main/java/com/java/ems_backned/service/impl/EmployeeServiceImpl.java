package com.java.ems_backned.service.impl;

import com.java.ems_backned.dto.dto.EmployeeDto;
import com.java.ems_backned.entity.Employee;
import com.java.ems_backned.exception.ResourceNotFoundException;
import com.java.ems_backned.mapper.EmployeeMapper;
import com.java.ems_backned.repository.EmployeeRepository;
import com.java.ems_backned.service.EmployeeService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployeeDto) {
            Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                              () -> new ResourceNotFoundException("Employee is not exists with given id : " + employeeId)
                      );
            employee.setFirstName(updateEmployeeDto.getFirstName());
            employee.setLastName(updateEmployeeDto.getLastName());
            employee.setEmail(updateEmployeeDto.getEmail());
            Employee updateEmployeeObj = employeeRepository.save(employee);
            return EmployeeMapper.mapToEmployeeDto(updateEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id : " + employeeId)
        );
        employeeRepository.deleteById(employeeId);
    }


}
