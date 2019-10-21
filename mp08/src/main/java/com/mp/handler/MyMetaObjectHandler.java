package com.mp.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description 自定义公共字段填充器
 * @Author lijian
 * @Date 2019/10/21 20:31
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyMetaObjectHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        LOGGER.info("start insert fill ....");
        Object gender = this.getFieldValByName("gender", metaObject);
        if (gender == null) {
            //避免使用metaObject.setValue()
            this.setFieldValByName("gender", 1, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object gender = this.getFieldValByName("gender", metaObject);
        if (gender == null) {
            LOGGER.info("start update fill ....");
            this.setFieldValByName("gender", 0, metaObject);
        }
    }
}
