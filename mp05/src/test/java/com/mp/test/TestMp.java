package com.mp.test;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author: li_jian
 * @version: 1.0
 * @date: 2019/10/14 21:33
 * @description：
 */
public class TestMp {
    private ApplicationContext ioc = new
            ClassPathXmlApplicationContext("applicationContext.xml");

    /**
     * 代码生成器 示例代码
     */
    @Test
    public void testGenerator() {
        // 1、全局配置
        com.baomidou.mybatisplus.generator.config.GlobalConfig config = new com.baomidou.mybatisplus.generator.config.GlobalConfig();
        config.setActiveRecord(true) // 是否支持AR模式
                .setAuthor("jianshu")   // 作者
                .setOutputDir("E:\\myCode\\mybatis-plus-in-action\\mp05\\src\\main\\java")      // 生成路径
                .setFileOverride(true) // 文件覆盖
                .setIdType(IdType.AUTO) // 主键策略
                .setServiceName("%sService") //设置生成的service接口名首字母是否为I,默认是以I开头
                .setBaseColumnList(true) // 基本列
                .setBaseResultMap(true); // 返回结果map

        // 2、数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL) // 设置数据库类型
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://172.19.8.51:3306/wmcTradeOrderDevTemp?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8")
                .setUsername("root")
                .setPassword("root");

        // 3、策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) // 全局大写命名
//                .setColumnNaming(NamingStrategy.underline_to_camel)  //表名 字段名 是否使用下滑线命名
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                .setInclude("tbl_employee") //生成的表
                .setTablePrefix("tbl_"); // 表前缀

        // 4、包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.mp")
                .setController("controller")
                .setEntity("beans")
                .setMapper("mapper")
                .setService("service")
                .setXml("mapper");

        // 5、整合配置
        AutoGenerator ag = new
                AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);

        // 6、执行
        ag.execute();
    }

}
