package com.mp.test;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
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

    EmployeeMapper employeeMapper = ioc.getBean("employeeMapper", EmployeeMapper.class);




    /**
     * 测试 乐观锁
     */
    @Test
    public void testOptimisticLocker() {

        Employee employee = new Employee();
        employee.setId(21);
        employee.setLastName("MP");
        employee.setAge(25);
        employee.setEmail("mp@qq.com");
        employee.setGender("0");
        employee.setVersion(2);

        employeeMapper.updateById(employee);

    }

    /**
     * 测试 SQL 执行分析插件
     */
    @Test
    public void testSqlExplain() {

        // 全表删除
        employeeMapper.delete(null);
    }

    /**
     * 测试分页插件
     */
    @Test
    public void testPage() {
        IPage<Employee> employeeIPage = employeeMapper.selectPage(new Page<>(2, 1), null);
        System.out.println("employeeIPage：" + employeeIPage.getRecords());
    }

}
