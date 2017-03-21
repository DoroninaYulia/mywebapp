package org.itstep.myWebApp.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.web.WebTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;

import static org.itstep.myWebApp.UserTestData.MAIL_1;
import static org.itstep.myWebApp.UserTestData.USER_1;
import static org.itstep.myWebApp.UserTestData.USER_2;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UserRestControllerTest extends WebTest{

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getAll() throws Exception {
        mockMvc.perform(get("/rest/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().string(objectMapper.writeValueAsString(Arrays.asList(USER_1, USER_2))))
                .andDo(print());
    }

    @Test
    public void getbyId() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/rest/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andReturn();

        User user = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), User.class);

        Assert.assertEquals(USER_1, user);
    }

    @Test
    public void create() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/rest/users")
                .content(objectMapper.writeValueAsString(MAIL_1))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

}