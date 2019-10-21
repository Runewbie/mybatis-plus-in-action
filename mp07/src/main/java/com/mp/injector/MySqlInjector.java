package com.mp.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.mp.methods.DeleteAll;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description 自定义全局操作 injector
 * @Author lijian
 * @Date 2019/10/21 16:57
 */
@Component
public class MySqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        //增加自定义方法
        methodList.add(new DeleteAll());
        return methodList;
    }
}
