package com.mengyunzhi.service;

import com.mengyunzhi.repository.Teacher;

import javax.persistence.EntityNotFoundException;

/**
 * Created by Administrator on 2017/7/26.
 */
public interface TeacherService {
    Teacher saveTeacher(Long id, Teacher teacher) throws EntityNotFoundException;
    void  deleteTeacher(Teacher teacher);
    void deleteTeacherById(Long id);
}
