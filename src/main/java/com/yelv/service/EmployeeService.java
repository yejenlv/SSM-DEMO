package com.yelv.service;

import com.yelv.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee getEmp(Integer id);

    public List<Employee> getAll();

    public void saveEmp(Employee employee);

    public boolean checkUser(String empName);

    public void updateEmp(Employee employee);

    public void deleteBatch(List<Integer> del_ids);

    public void deleteEmp(Integer id);
}
