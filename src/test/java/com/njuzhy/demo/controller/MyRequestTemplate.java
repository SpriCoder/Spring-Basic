package com.njuzhy.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Author stormbroken
 * 标准的Mock工具类
 * Create by 2021/03/07
 * @Version 1.0
 **/

@Component
public class MyRequestTemplate {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * POST 模板
     * @param url 请求的URL
     * @param object Post Body
     * @return String 格式的结果
     */
    public String postTemplate(String url, Object object) throws Exception{

        init();
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders
                .post(url)
                .header("Accept-Encoding", "gzip, deflate")
                .header("Connection", "keep-alive")
                .header("Accept-Language", "zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7")
                .contentType(MediaType.APPLICATION_JSON);

        if(object != null){
            String jsonResult = JSONObject.toJSONString(object);
            mockHttpServletRequestBuilder = mockHttpServletRequestBuilder.content(jsonResult);
        }

        MvcResult mvcResult = mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        return mvcResult.getResponse().getContentAsString();
    }
}
