package com.yelv.service.impl;

import com.yelv.entity.Employee;
import com.yelv.entity.EmployeeExample;
import com.yelv.mapper.EmployeeMapper;
import com.yelv.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 根据ID查询员工信息
     * @param id
     * @return
     */
    @Override
    public Employee getEmp(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }

    /**
     *
     * 查询所有员工
     * @return
     */
    @Override
    public List<Employee> getAll() {
        return employeeMapper.selectByExampleWithDept(null);
    }

    /**
     * 员工保存
     * @param employee
     */
    @Override
    public void saveEmp(Employee employee) {
        employeeMapper.insert(employee);
    }

    /**
     * 校验
     * @param empName
     * @return true代表当前用户可用
     */
    @Override
    public boolean checkUser(String empName) {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        long count = employeeMapper.countByExample(employeeExample);
        return count == 0;
    }

    /**
     * 员工更新
     * @param employee
     */
    @Override
    public void updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    /**
     * 批量删除
     * @param del_ids
     */
    @Override
    public void deleteBatch(List<Integer> del_ids) {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmpIdIn(del_ids);
        employeeMapper.deleteByExample(employeeExample);
    }

    /**
     * 单个删除
     * @param id
     */
    @Override
    public void deleteEmp(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }
}
