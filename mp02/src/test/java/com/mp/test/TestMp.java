package com.mp.test;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mp.beans.Employee;
import com.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 通用删除操作
     */
    @Test
    public void testCommonDelete() {
//        // 1、根据id删除
//        Integer result = employeeMapper.deleteById(15);
//        System.out.println("result：" + result);
//
//        // 2、根据 deleteByMap 条件删除
//        Map<String, Object> columnMap  = new HashMap<>();
//        columnMap.put("last_name","MP");
//        columnMap.put("email","mybatis-plus@github.com");
//        Integer ret = employeeMapper.deleteByMap(columnMap);
//        System.out.println("ret：" + ret);

        // 3、批量删除
        List<Integer> idList = new ArrayList<Integer>();
        idList.add(18);
        idList.add(19);
        Integer deleteResult = employeeMapper.deleteBatchIds(idList);
        System.out.println("deleteResult：" + deleteResult);
    }

    /**
     * 通用查询操作
     */
    @Test
    public void testCommonSelect() {
        // 1、通过id查询
        Employee employee = employeeMapper.selectById(14);
        System.out.println(employee);

        // 2、通过多个列查询 id+lastName
        Employee employee1 = new Employee();
        employee1.setId(13);
        employee1.setLastName("White");
        Wrapper<Employee> employeeWrapper = new QueryWrapper<Employee>(employee1);
        Employee selectOne = employeeMapper.selectOne(employeeWrapper);
        System.out.println(selectOne);

        // 3、通过多个id进行查询
        List<Integer> idList = new ArrayList<Integer>();
        idList.add(11);
        idList.add(12);
        idList.add(13);
        idList.add(14);
        List<Employee> employeeList = employeeMapper.selectBatchIds(idList);
        System.out.println("employeeList：" + employeeList);

        // 4、通过 selectMaps 查询
        Map<String, Object> columnMap = new HashMap<String, Object>();
        columnMap.put("last_name", "White");
        columnMap.put("gender", 0);
        List<Employee> selectByMap = employeeMapper.selectByMap(columnMap);
        System.out.println("selectByMap：" + selectByMap);

        // 5、分页查询 selectPage 使用分页查询需要在 applicationContext.xml 中添加 分页查询插件 配置
        IPage<Employee> employeeIPage = employeeMapper.selectPage(new Page<>(2, 1), null);
        System.out.println("employeeIPage：" + employeeIPage.getRecords());
    }

    /**
     * 通用更新操作
     */
    @Test
    public void testCommonUpdate() {
        // 初始化employee 对象
        Employee employee = new Employee();
        employee.setId(19);
        employee.setLastName("MP");
        employee.setEmail("mybatis-plus@github.com");
        employee.setGender(0);
//        employee.setAge(33);

        // 单个更新
        Integer result = employeeMapper.updateById(employee);
        System.out.println("result：" + result);

        // 批量更新， 如果 Wrapper 为空，则全部更新
        result = employeeMapper.update(employee, null);
        System.out.println("result：" + result);
    }

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
        System.out.println("key：" + key);
    }

    @Test
    public void testEnvironment() throws Exception {
        DataSource ds = ioc.getBean("dataSource", DataSource.class);
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
