package com.mp.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mp.beans.Employee;
import com.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


/**
 * @author: li_jian
 * @version: 1.0
 * @date: 2019/10/14 21:33
 * @description：
 */
public class TestMp {
    private ApplicationContext ioc = new
            ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper employeeMapper = ioc.getBean("employeeMapper", EmployeeMapper.class);

    /**
     * AR 复杂分页操作
     */
    @Test
    public void testARPage() {
        Employee employee = new Employee();
        IPage<Employee> page = employee.selectPage(
                new Page<>(1, 2),
                new QueryWrapper<Employee>().like("email", ".com"));

        System.out.println(page.getRecords());
    }

    /**
     * AR 删除操作
     */
    @Test
    public void testARDelete() {
        // 1、根据id删除
        Employee employee = new Employee();
        boolean deleteById = employee.deleteById(25);
        System.out.println(deleteById);

        //2、根据id删除
        employee.setId(26);
        boolean delete = employee.deleteById();
        System.out.println(delete);

        //3、wrapper 删除
        boolean delete1 = employee.delete(
                new QueryWrapper<Employee>().like("last_name", "M"));
        System.out.println(delete1);
    }

    /**
     * AR 查询操作
     */
    @Test
    public void testARSelect() {
        Employee employee = new Employee();
        // 1、查询操作，直接根据id查询 selectById(id)
        Employee result = employee.selectById(14);
        System.out.println(result);

        // 2、查询操作
        employee.setId(23);
        Employee employee1 = employee.selectById();
        System.out.println(employee1);

        //3、查询操作 selectAll
        List<Employee> employees = employee.selectAll();
        System.out.println(employees);

        //4、查询操作 selectList
        List<Employee> employeeList = employee.selectList(
                new QueryWrapper<Employee>().like("last_name", "M"));
        System.out.println(employeeList);

        //5、统计查询
        Integer count = employee.selectCount(
                new QueryWrapper<Employee>().like("last_name", "M"));
        System.out.println(count);
    }

    /**
     * AR 修改操作
     */
    @Test
    public void testARUpdate() {
        Employee employee = new Employee();
        employee.setId(27);
        employee.setLastName("李老师");
        employee.setGender(2);
        employee.setAge(23);

        boolean r = employee.updateById();
        System.out.println(r);

    }

    /**
     * AR 插入操作
     */
    @Test
    public void testARInsert() {
        Employee employee = new Employee();
        employee.setGender(1);
        employee.setLastName("ar_insert");

        boolean b = employee.insert();
        System.out.println(b);

    }
}
