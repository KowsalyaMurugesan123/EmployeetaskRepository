package com.example.SpringBootTask.entity;

import javax.persistence.*;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_Id")
    private int employeeId;
    @Column(name = "employee_Name")
    private String employeeName;
    @Column(name = "mobile_Number")
    private String mobileNumber;
    @Column(name = "mail_Id")
    private String mailId;
    @Column(name = "age")
    private int age;
    @Column(name = "salary")
    private int salary;
    @Column(name = "pf_Number")
    private int pfNumber;

    public Employee(int employeeId, String employeeName, String mobileNumber, String mailId, int age, int salary, int pfNumber) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.mobileNumber = mobileNumber;
        this.mailId = mailId;
        this.age = age;
        this.salary = salary;
        this.pfNumber = pfNumber;
    }

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getPfNumber() {
        return pfNumber;
    }

    public void setPfNumber(int pfNumber) {
        this.pfNumber = pfNumber;
    }
}
