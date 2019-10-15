package com.mp.test;

import com.mp.beans.Employee;
import com.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

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
     * 通用 插入操作
     */
    @Test
    public void testCommonInsert() {
        // 初始化employee 对象
        Employee employee = new Employee();
        employee.setLastName("MP");
        employee.setEmail("mp@github.com");
        employee.setGender(1);
        employee.setAge(22);

        employee.setSalary(2000.0);

        // 插入到数据库 insert方法在插入时， 会根据实体类的每个属性进行非空判断，只有非空的属性对应的字段才会出现到SQL语句中
        int ret = employeeMapper.insert(employee);
        System.out.println("result：" + ret);

        // 获取当前数据在数据库中的主键值
        Integer key = employee.getId();
        System.out.println("key："+key);
    }

    @Test
    public void testEnvironment() throws Exception {
        DataSource ds = ioc.getBean("dataSource", DataSource.class);
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
