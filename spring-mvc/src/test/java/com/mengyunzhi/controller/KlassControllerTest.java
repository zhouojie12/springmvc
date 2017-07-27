package com.mengyunzhi.controller;

import com.mengyunzhi.repository.Klass;
import com.mengyunzhi.service.KlassService;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.ResultActions;


/**
 * Created by panjie on 17/4/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc       // 自动配置 模似MVC
public class KlassControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private KlassService klassService;

    @Test
    public void save() throws Exception {

    }

    @Test
    // 由于get()与http请求的get命名相同，在这里重新命名以防止冲突。
    public void getTest() throws Exception {
        // 直接添加一个实体
        Klass klass = klassService.getNewKlass();

        // 发起http请求来查询这个实体
        this.mockMvc.perform(get("/klass/" + klass.getId().toString()))
                .andDo(print())
                .andExpect(jsonPath("$.id", is(klass.getId().intValue())));
    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }
}