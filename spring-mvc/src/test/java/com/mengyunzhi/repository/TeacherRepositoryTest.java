package com.mengyunzhi.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by panjie on 17/4/6.
 */
// 使用以下两个注解来说明：本测试类基于SpringBoot。(必须)
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherRepositoryTest {
    // @Autowired注解：自动加载Spring为我们自动实例化的实现了TeacherRepository接口的对象
    @Autowired
    private TeacherRepository teacherRepository;

    // @Test：本方法为一个单元测试方法
    @Test
    public void addTeacher() {
        // 执行数据保存操作
        teacherRepository.save(new Teacher());

        // 打印Spring为我们自动实例化的对象
        System.out.println(teacherRepository);
    }
}