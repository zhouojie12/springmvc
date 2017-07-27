package com.mengyunzhi.service;

import com.mengyunzhi.repository.Teacher;
import com.mengyunzhi.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

/**
 * Created by Administrator on 2017/7/26.
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    @Override
    public Teacher saveTeacher(Long id, Teacher teacher) throws EntityNotFoundException {
        // 判断是否存在该实体，如果不存在，则报错
        if (teacherRepository.findOne(id) == null) {
            throw new EntityNotFoundException("传入的ID值：" + id.toString() + "有误。未找到对应的实体");
        }

        // 对实体ID赋值, 并执行更新操作
        teacher.setId(id);
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherRepository.delete(teacher);
        return;
    }

    @Override
    public void deleteTeacherById(Long id) {
        teacherRepository.delete(id);
        return;
    }

    @Override
    public Teacher getNewTeacher() {
        Teacher teacher = new Teacher(
                "示例教师",
                "zhangsan@yunzhiclub.com",
                "scse of hebut",
                true);
        teacherRepository.save(teacher);
        return teacher;
    }
}
