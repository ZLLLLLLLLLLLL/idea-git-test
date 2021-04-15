package com.zl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zl.entity.User;
import com.zl.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class MybatisPlusApplicationTests {
   @Autowired
    private UserService userService;

    @Test
    public void testDelete() {


      /* *//* User user = new User();
        user.setName("lisi").setAge(20).setEmail("zhangsan@163.com");
        userService.save(user);*//*
        List<Object> objects = userService.listObjs();
        for (Object object : objects) {
            System.out.println(object);
        }*/

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        // Step2： 构造查询条件
        queryWrapper
                .select("id", "name", "age")
                .eq("age", 20)
                .like("name", "j");

        // Step3：执行查询
        userService
                .list(queryWrapper)
                .forEach(System.out::println);
    }

    @Test
    public void testPage() {
        // Step1：创建一个 Page 对象
//        Page<User> page = new Page<>();
         Page<User> page = new Page<>(2, 1);
        // Step2：调用 mybatis-plus 提供的分页查询方法
        userService.page(page, null);
        // Step3：获取分页数据
        System.out.println(page.getCurrent()); // 获取当前页
        System.out.println(page.getTotal()); // 获取总记录数
        System.out.println(page.getSize()); // 获取每页的条数
        System.out.println(page.getRecords()); // 获取每页数据的集合
        System.out.println(page.getPages()); // 获取总页数
        System.out.println(page.hasNext()); // 是否存在下一页
        System.out.println(page.hasPrevious()); // 是否存在上一页
    }


}
