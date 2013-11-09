package com.Chat.Common.Util;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created with IntelliJ IDEA.
 * User: miyamoto_s
 * Date: 2013/10/20
 * Time: 2:31
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class CryptUtilTest {
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void encryptTest() throws Exception {
        String test = "test";
        Assert.assertEquals("eVucgzlckDzytMCE6exvQQ==", CryptUtil.encrypt(test));
    }


    @Test
    public void decryptTest() throws Exception {
        String defalt = "test.hoge@gmail.com";
        String result = "OvS4PMWjEiSTs9DS4y7LM51WlbLitAh8Bjm/OR0TsmQ=";
        Assert.assertEquals(result, CryptUtil.encrypt(defalt));
        Assert.assertEquals(defalt, CryptUtil.decrypt(result));
    }
}
