package com.example.SpringBootTask.EmployeeController;

import com.example.SpringBootTask.Dto.EmployeeDto;
import com.example.SpringBootTask.Service.EmployeeService;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/Employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    // build create User REST API
    @PostMapping(path = "/Save")
    public ResponseEntity<EmployeeDto> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto) throws ValidationException {

        EmployeeDto savedemploye = employeeService.addEmployee(employeeDto);
        return new ResponseEntity<>(savedemploye, HttpStatus.CREATED);
    }

    // build delete User REST API
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return "employee deleted successfully!!!";
    }

    // build update User REST API
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeDto employeeDto) {
        EmployeeDto employeeDto1 = employeeService.updateEmployee(id, employeeDto);
        return ResponseEntity.ok().body(employeeDto1);
    }

    // build get All user  REST API
    @GetMapping("/all")
    public List<EmployeeDto> getAllEmployee() {

//        return employeeService.getAllEmployee().stream().map(employee -> Mapper.mapToEmployeeDTO(employee))
//                .collect(Collectors.toList());
        return employeeService.getAllEmployee();
    }

    // build get user by id REST API
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeid(@PathVariable("id") int id) {
        EmployeeDto employeeDto = employeeService.getEmployeeid(id);
        return ResponseEntity.ok().body(employeeDto);
    }

    //build get emloyee pagination user REST API
    //http://localhost:8080/api/v1/Employee/page?pageNo=0&pageSize=7&sortBy=employeeid&sorting=asc
    // @GetMapping("page")
    @GetMapping("/page")
    public Page<EmployeeDto> getAllEmployee(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sorting", defaultValue = "asc", required = false) String sorting
    ) {
        Page<EmployeeDto> employeeDtos = employeeService.getAllEmployee(pageNo, pageSize, sortBy, sorting);
        return employeeDtos;
    }
}

