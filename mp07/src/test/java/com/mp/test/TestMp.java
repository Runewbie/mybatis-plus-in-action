package com.mp.test;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

import java.util.Arrays;


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
     * 测试逻辑删除
     */
    @Test
    public void testLogicDeleteById() {
        employeeMapper.deleteById(1);
    }
    @Test
    public void testLogicDeleteBatchIds() {
        employeeMapper.deleteBatchIds(Arrays.asList(15, 16, 17));
    }
    @Test
    public void testLogicDelete() {
        employeeMapper.delete(new QueryWrapper<Employee>().eq("age", 25));
    }

    /**
     * 测试自定义全局操作
     */
    @Test
    public void testInjector(){
        int ret = employeeMapper.deleteAll();
        System.out.println(ret);

    }
}
