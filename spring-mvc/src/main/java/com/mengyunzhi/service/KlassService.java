package com.mengyunzhi.service;

import com.mengyunzhi.repository.Klass;

/**
 * Created by Administrator on 2017/7/26.
 */
public interface KlassService {
    Klass add(String name, Long teacherId);
    Klass get(Long id);
    void delete(Long id);
    Klass update(Long id, String name, Long teacherId);
    Klass save(String name, Long teacherId);

}
