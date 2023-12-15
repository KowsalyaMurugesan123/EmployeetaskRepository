package com.example.SpringBootTask.Service.impl;

import com.example.SpringBootTask.Dto.EmployeeDto;
import com.example.SpringBootTask.EmployeeRepo.EmployeeRepository;
import com.example.SpringBootTask.ExceptionHandling.ResourceNotFoundException;
import com.example.SpringBootTask.ExceptionHandling.ValidationException;
import com.example.SpringBootTask.Mapper.Mapper;
import com.example.SpringBootTask.Service.EmployeeService;
import com.example.SpringBootTask.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) throws ValidationException {
        if (employeeRepository.existsByMailId(employeeDto.getMailId())) {
            throw new ValidationException("Invalid email format");
        }

        if (employeeRepository.existsByMobileNumber(employeeDto.getMobileNumber())) {
            throw new ValidationException("Invalid mobile number");
        }

        Employee employee = Mapper.mapToEmployee(employeeDto);
        Employee save = employeeRepository.save(employee);
        return Mapper.mapToEmployeeDTO(save);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDto updateEmployee(int id, EmployeeDto updateRequest) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee id not Found"));
        Employee emp = Mapper.mapToEmployee(updateRequest);
        emp.setEmployeeId(employee.getEmployeeId());
        emp.setEmployeeName(updateRequest.getEmployeeName());
        emp.setMobileNumber(updateRequest.getMobileNumber());
        emp.setMailId(updateRequest.getMailId());
        emp.setAge(updateRequest.getAge());
        emp.setSalary(updateRequest.getSalary());
        emp.setPfNumber(updateRequest.getPfNumber()
        );

        Employee save = employeeRepository.save(emp);
        return Mapper.mapToEmployeeDTO(save);
    };

    @Override
    public List<EmployeeDto> getAllEmployee() {

        // Employee employee= Mapper.mapToEmployeeDTO(Employee );
        List<EmployeeDto> allEmployees = employeeRepository.findAll().stream().map(employee -> Mapper.mapToEmployeeDTO(employee)).collect(Collectors.toList());
        return allEmployees;
    }

    @Override
    public EmployeeDto getEmployeeid(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id not present" + id));
        return Mapper.mapToEmployeeDTO(employee);
    }

    @Override
    public Page<EmployeeDto> getAllEmployee(int pageNo, int pageSize, String sortBy, String sorting) {
        Sort sort = sorting.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Employee> employeePage = employeeRepository.findAll(pageable);
        Page pagination = employeePage.map(employee -> Mapper.mapToEmployeeDTO(employee));
        return pagination;
    }
}
