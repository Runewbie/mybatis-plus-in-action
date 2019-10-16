package com.mp.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
 */
@Data
@ToString
//@TableName(value = "tbl_employee")  // ==> 全局的表前缀策略配置
public class Employee {

    /**
     * @TableId:
     *      value: 指定表中的主键的列名，如果实体属性名与列名一致，可以省略不指定
     *      type：指定主键策略
     * 设置主键自增
     */
//    @TableId(value = "id", type = IdType.AUTO) // ==> 全局表主键生成策略

    private Integer id;
    @TableField(value = "last_name")
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;

    // 当前字段是否在数据库中存在，如果不存在则忽略该字段插入到数据库中
    @TableField(exist = false)
    private Double salary;
}
