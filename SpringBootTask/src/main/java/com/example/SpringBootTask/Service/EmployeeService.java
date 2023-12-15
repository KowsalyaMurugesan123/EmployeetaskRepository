package com.example.SpringBootTask.Service;


import com.example.SpringBootTask.Dto.EmployeeDto;
import javax.validation.ValidationException;
import org.springframework.data.domain.Page;
import java.util.List;
public interface EmployeeService {
    public EmployeeDto addEmployee(EmployeeDto employeeDto) throws ValidationException;
    public void deleteEmployee(int id);
    public EmployeeDto updateEmployee(int id, EmployeeDto updateRequest);
    List<EmployeeDto> getAllEmployee();
    public EmployeeDto getEmployeeid(int id);
    public Page<EmployeeDto> getAllEmployee(int pageNo, int pageSize, String sortBy, String sorting);
}
