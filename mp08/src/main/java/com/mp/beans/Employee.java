package com.mp.beans;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: li_jian
 * @version: 1.0
 * @date: 2019/10/13 22:30
 * @description： 定义JavaBean中成员变量是所使用的类型：
 * 因为每个基本类型都有一个默认值：
 * int → 0
 * boolean → false
 *
 * mybatis-plus默认会使用实体类的小写类名作为表名
 *
 * 继承 Model 类，开启AR模式
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("tbl_employee")
public class Employee extends Model<Employee> {

    private Integer id;
    private String lastName;
    private String email;

    /**
     * 添加字段自动填充注解
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer gender;

    private Integer age;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
