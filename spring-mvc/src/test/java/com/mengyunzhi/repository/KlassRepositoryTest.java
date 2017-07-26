package com.mengyunzhi.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by panjie on 17/4/6.
 */
// 使用以下两个注解来说明：本测试类基于SpringBoot。(必须)
@RunWith(SpringRunner.class) @SpringBootTest
public class KlassRepositoryTest {
    // @Autowired注解：自动加载Spring为我们自动实例化的实现了KlassRepository接口的对象
    @Autowired
    private KlassRepository klassRepository;

    // @Before注解：在执行单元测试方法 前 执行。
    @Before
    public void before() {
    }

    // @After：在执行单元测试方法 后 执行。
    @After
    public void after() {
    }

    @Test
    public void test() {

    }
    @Autowired
    TeacherRepository teacherRepository;
    @Test(expected = DataIntegrityViolationException.class)
    public void relationDeleteException() {
        Teacher teacher = new Teacher("zhangsan",
                "zhangsan@yunzhiclub.com",
                "scse of hebut",
                false);
        teacherRepository.save(teacher);
        Klass klass = new Klass(teacher, "一一班");
        klassRepository.save(klass);
        teacherRepository.delete(teacher);
    }
}