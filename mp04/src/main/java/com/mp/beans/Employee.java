package com.mp.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.ToString;

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
public class Employee extends Model<Employee> {

    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;

    // 当前字段是否在数据库中存在，如果不存在则忽略该字段插入到数据库中
    @TableField(exist = false)
    private Double salary;
}
