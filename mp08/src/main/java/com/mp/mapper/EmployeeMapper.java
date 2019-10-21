package com.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mp.beans.Employee;

/**
 * @author: li_jian
 * @version: 1.0
 * @date: 2019/10/14 22:04
 * @description： mapper接口
 * 实现方式:
 * 基于 Mybatis
 *      需要编写 EmployeeMapper 接口，并手动编写 CRUD 方法
 *      提供 EmployeeMapper.xml 映射文件，并手动编写每个方法对应的 SQL 语句.
 *
 * 基于 MP
 *      只需要创建 EmployeeMapper 接口, 并继承 BaseMapper 接口.这就是使用 MP
 *      需要完成的所有操作，甚至不需要创建 SQL 映射文件。
 *      BaseMapper<T>：泛型指定的就是当前mapper接口所操作的实体类型
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    // 使用 mybatis 插入数据时获取主键值
    //   Integer  insertEmployee(Employee employee );
    //   <insert useGeneratedKeys="true" keyProperty="id" > SQL...</insert>
}
