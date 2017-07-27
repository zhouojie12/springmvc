package com.mengyunzhi.service;

import com.mengyunzhi.repository.Klass;
import com.mengyunzhi.repository.KlassRepository;
import com.mengyunzhi.repository.Teacher;
import com.mengyunzhi.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/7/26.
 */
@Service
public class KlassServiceImpl implements KlassService {
    @Autowired
    private KlassRepository klassRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Klass get(Long id) {
        return klassRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        klassRepository.delete(id);
        return;
    }

    @Override
    public Klass update(Long id, String name, Long teacherId) {

        // 实例化班级，赋班级名称
        Klass klass = klassRepository.findOne(id);
        klass.setName(name);

        // 实例化传入的教师，设置教师
        Teacher teacher = teacherRepository.findOne(teacherId);
        klass.setTeacher(teacher);

        return klassRepository.save(klass);
    }

    @Override
    public Klass save(String name, Long teacherId) {
        // 实例化，并设置班级名称
        Klass klass = new Klass();
        klass.setName(name);

        // 获取教师
        Teacher teacher = teacherRepository.findOne(teacherId);

        // 设置教师
        klass.setTeacher(teacher);

        // 保存
        return klassRepository.save(klass);
    }
}
