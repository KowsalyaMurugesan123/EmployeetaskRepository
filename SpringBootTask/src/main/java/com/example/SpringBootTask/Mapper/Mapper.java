package com.example.SpringBootTask.Mapper;
import com.example.SpringBootTask.Dto.EmployeeDto;
import com.example.SpringBootTask.entity.Employee;
public class Mapper {
    public static EmployeeDto mapToEmployeeDTO(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto(

                employee.getEmployeeId(),
                employee.getEmployeeName(),
                employee.getMobileNumber(),
                employee.getMailId(),
                employee.getAge(),
                employee.getSalary(),
                employee.getPfNumber()
        );
        return employeeDto;
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getEmployeeId(),
                employeeDto.getEmployeeName(),
                employeeDto.getMobileNumber(),
                employeeDto.getMailId(),
                employeeDto.getAge(),
                employeeDto.getSalary(),
                employeeDto.getPfNumber()
        );
        return employee;
    }
}

