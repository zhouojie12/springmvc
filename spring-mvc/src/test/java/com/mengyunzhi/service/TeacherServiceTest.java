package com.mengyunzhi.service;

import com.mengyunzhi.repository.Teacher;
import com.mengyunzhi.repository.TeacherRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by panjie on 17/4/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherServiceTest {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacherTest() {
        // 实例化教师 李四
        Teacher teacherLisi = new Teacher("lisi",
                "lisi@email.com",
                "scse of hebut",
                false);

        // 保存李四至数据库
        teacherLisi = teacherRepository.save(teacherLisi);

        // 打印李四的数据
        System.out.println(teacherLisi);

        // 实例化教师 张三
        Teacher teacherZhangsan = new Teacher(
                "zhangsan",
                "zhangsan@yunzhiclub.com",
                "scse of hebut",
                true);

        // 将张三的数据更新到原李四的数据中
        Teacher newTeacher = teacherService.saveTeacher(teacherLisi.getId(), teacherZhangsan);

        // 查询并打印更新后的数据
        System.out.println(newTeacher);
    }

    /**
     * 更新的数据不存在于数据表中时，发生错误，并抛出异常
     */
    @Test(expected = EntityNotFoundException.class)     // 此方法的预期结果是获取到一个EntityNotFoundException异常
    public void saveTeacherErrorTest() {
        // 指定id为0
        Long id = 0L;

        // 实例化教师张三
        Teacher teacherZhangsan = new Teacher(
                "zhangsan",
                "zhangsan@yunzhiclub.com",
                "scse of hebut",
                true);

        // 使用张三的数据来更新0号教师的数据
        teacherService.saveTeacher(id, teacherZhangsan);
    }
    @Test
    public void deleteTeacherTest() {
        // 实例化教师 李四
        Teacher teacherLisi = new Teacher("lisi",
                "lisi@email.com",
                "scse of hebut",
                false);

        // 保存李四至数据库
        teacherLisi = teacherRepository.save(teacherLisi);
        System.out.println(teacherLisi);    // 打印插入的数据

        // 执行删除操作
        teacherService.deleteTeacher(teacherLisi);

        // 数据查找，看数据是否进行了删除
        Teacher teacher = teacherRepository.findOne(teacherLisi.getId());
        System.out.println(teacher);
    }
    @Test
    public void deleteTeacherByIdTest() {
        // 实例化教师 李四
        Teacher teacherLisi = new Teacher("lisi",
                "lisi@email.com",
                "scse of hebut",
                false);

        // 保存李四至数据库
        teacherLisi = teacherRepository.save(teacherLisi);
        System.out.println(teacherLisi);

        // 删除关键字对应的实体
        teacherService.deleteTeacherById(teacherLisi.getId());

        // 数据查找，看数据是否进行了删除
        Teacher teacher = teacherRepository.findOne(teacherLisi.getId());
        System.out.println(teacher);

    }
    @Test
    public void getNewTeacher() {
        assertThat(teacherService.getNewTeacher()).isNotNull();
    }
}
