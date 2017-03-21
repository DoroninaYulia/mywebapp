package org.itstep.myWebApp.web.ui;

import org.itstep.myWebApp.web.WebTest;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


public class UserControllerTest extends WebTest {

    @Test
    public void getAll() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(forwardedUrl("/WEB-INF/jsp/userList.jsp"))
                .andDo(print());
    }

    @Test
    public void delete() throws Exception {
        mockMvc.perform(get("/users/delete").param("id", "1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/users"))
                .andDo(print());
    }

    @Test
    public void deleteNotFound() throws Exception {
        mockMvc.perform(get("/users/delete").param("id", "0"))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void create() throws Exception {

    }

    @Test
    public void save() throws Exception {

    }

}