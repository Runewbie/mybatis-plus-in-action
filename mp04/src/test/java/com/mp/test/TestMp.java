package com.mp.test;

import com.mp.beans.Employee;
import com.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


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
     * AR 插入操作
     */
    @Test
    public void testARInsert(){
        Employee employee = new Employee();
        employee.setGender(1);
        employee.setLastName("ar_insert");

        boolean b = employee.insert();
        System.out.println(b);

    }
}
