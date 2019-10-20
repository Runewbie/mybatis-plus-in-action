package com.mp.service.impl;

import com.mp.beans.Employee;
import com.mp.mapper.EmployeeMapper;
import com.mp.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lijian
 * @since 2019-10-20
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    // 不用进行mapper注入,ServiceImpl 中已经自动注入了

    /**
     * EmployeeServiceImpl 继承了 ServiceImpl 类,mybatis-plus 通过这种方
     * 式为我们注入了 EmployeeMapper,这样可以使用 service 层默认为我们提供的很
     * 多方法,也可以调用我们自己在 dao 层编写的操作数据库的方法.
     */
}
