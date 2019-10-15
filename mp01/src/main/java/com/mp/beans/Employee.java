package com.mp.beans;

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
 */
@Data
@ToString
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;
}
